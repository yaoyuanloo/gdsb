package com.fortunes.javamg.modules.sys.security.cas;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasAuthenticationException;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.cas.CasToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.TicketValidationException;
import org.jasig.cas.client.validation.TicketValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fortunes.javamg.common.utils.SpringContextHolder;
import com.fortunes.javamg.common.utils.StringUtils;
import com.fortunes.javamg.modules.sys.entity.Menu;
import com.fortunes.javamg.modules.sys.entity.Role;
import com.fortunes.javamg.modules.sys.entity.User;
import com.fortunes.javamg.modules.sys.service.SystemService;
import com.fortunes.javamg.modules.sys.utils.UserUtils;

/**
 * 
 * @author cloud
 *
 */
public class SystemCasRealm extends CasRealm {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private SystemService systemService;

	/**
	 * 获取系统业务对象
	 */
	public SystemService getSystemService() {
		if (systemService == null) {
			systemService = SpringContextHolder.getBean(SystemService.class);
		}
		return systemService;
	}

	@Override
	public String getName() {
		return "systemCasRealm";
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof CasToken; // 仅支持CasToken类型的Token
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("SystemCasRealm2-getName():" + getName());
		String username = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// authorizationInfo.setRoles(userService.findRoles(username));
		// authorizationInfo.setStringPermissions(userService.findPermissions(username));
		List<Menu> list = UserUtils.getMenuList();
		for (Menu menu : list) {
			// 跳过未设置权限的菜单
			if (StringUtils.isBlank(menu.getPermission())) {
				continue;
			}
			// 添加基于Permission的权限信息
			for (String permission : StringUtils.split(menu.getPermission(), ",")) {
				info.addStringPermission(permission);
			}
		}
		// 添加用户权限
		info.addStringPermission("user");

		User user = getSystemService().getUserByLoginName(username);
		// 获取登录的用户相关角色
		// User user = getSystemService().getUser(principal.getId());
		// 添加用户角色信息
		for (Role role : user.getRoleList()) {
			info.addRole(role.getEnname());
		}
		return info;
	}

	/**
	 * Authenticates a user and retrieves its information.
	 * 
	 * @param token
	 *            the authentication token
	 * @throws AuthenticationException
	 *             if there is an error during authentication.
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		CasToken casToken = (CasToken) token;
		if (token == null) {
			return null;
		}

		String ticket = (String) casToken.getCredentials();
		if (!org.apache.shiro.util.StringUtils.hasText(ticket)) {
			return null;
		}

		TicketValidator ticketValidator = ensureTicketValidator();

		try {
			// contact CAS server to validate service ticket
			Assertion casAssertion = ticketValidator.validate(ticket, getCasService());
			// get principal, user id and attributes
			AttributePrincipal casPrincipal = casAssertion.getPrincipal();
			String userId = casPrincipal.getName();
			logger.debug("Validate ticket : {} in CAS server : {} to retrieve user : {}",
					new Object[] { ticket, getCasServerUrlPrefix(), userId });
			
			User user = getSystemService().getUserByLoginName(userId);
			if(user == null || (user != null && StringUtils.isBlank(user.getName()))){
				throw new CasAuthenticationException();
			}
			
			Map<String, Object> attributes = casPrincipal.getAttributes();
			// refresh authentication token (user id + remember me)
			casToken.setUserId(userId);
			String rememberMeAttributeName = getRememberMeAttributeName();
			String rememberMeStringValue = (String) attributes.get(rememberMeAttributeName);
			boolean isRemembered = rememberMeStringValue != null && Boolean.parseBoolean(rememberMeStringValue);
			if (isRemembered) {
				casToken.setRememberMe(true);
			}
			// create simple authentication info
			List<Object> principals = CollectionUtils.asList(userId, attributes);
			PrincipalCollection principalCollection = new SimplePrincipalCollection(principals, getName());
			return new SimpleAuthenticationInfo(principalCollection, ticket);
		} catch (TicketValidationException e) {
			throw new CasAuthenticationException("Unable to validate ticket [" + ticket + "]", e);
		}
	}
}

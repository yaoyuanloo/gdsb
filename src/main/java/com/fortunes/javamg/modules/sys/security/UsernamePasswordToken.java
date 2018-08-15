/**
 * 
 */
package com.fortunes.javamg.modules.sys.security;

/**
 * 用户和密码（包含验证码）令牌类
 * 
 * @version 2013-5-19
 */
public class UsernamePasswordToken extends org.apache.shiro.authc.UsernamePasswordToken {

	private static final long serialVersionUID = 1L;

	/**
	 * 验证码
	 */
	private String captcha;
	/**
	 * 是否手机登录
	 */
	private boolean mobileLogin;

	/**
	 * 登陆类型
	 */
	private String loginType;

	public UsernamePasswordToken() {
		super();
	}

	public UsernamePasswordToken(String username, char[] password, boolean rememberMe, String host, String captcha,
			boolean mobileLogin) {
		super(username, password, rememberMe, host);
		this.captcha = captcha;
		this.mobileLogin = mobileLogin;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public boolean isMobileLogin() {
		return mobileLogin;
	}

	public String getLoginType() {
		return this.loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

}
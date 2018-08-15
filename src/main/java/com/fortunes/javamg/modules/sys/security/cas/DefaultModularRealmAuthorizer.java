package com.fortunes.javamg.modules.sys.security.cas;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;

public class DefaultModularRealmAuthorizer extends ModularRealmAuthorizer {

	private Map<String, Object> definedRealms;
	/**
     * Returns <code>true</code> if any of the configured realms'
     * {@link #isPermitted(org.apache.shiro.subject.PrincipalCollection, String)} returns <code>true</code>,
     * <code>false</code> otherwise.
     */
    public boolean isPermitted(PrincipalCollection principals, String permission) {
        assertRealmsConfigured();
        Set<String> realmNames = principals.getRealmNames();
        Realm realm = null;
        for (String realmName : realmNames) {
        	realm =	(Realm) definedRealms.get(realmName);
		}
        //Object obj = principals.getPrimaryPrincipal();
        if (!(realm instanceof Authorizer)){
        	return false;
        };
        if (((Authorizer) realm).isPermitted(principals, permission)) {
            return true;
        }
        return false;
    }

    /**
     * Returns <code>true</code> if any of the configured realms'
     * {@link #isPermitted(org.apache.shiro.subject.PrincipalCollection, Permission)} call returns <code>true</code>,
     * <code>false</code> otherwise.
     */
    public boolean isPermitted(PrincipalCollection principals, Permission permission) {
        assertRealmsConfigured();
        for (Realm realm : getRealms()) {
            if (!(realm instanceof Authorizer)) continue;
            if (((Authorizer) realm).isPermitted(principals, permission)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns <code>true</code> if any of the configured realms'
     * {@link #isPermittedAll(org.apache.shiro.subject.PrincipalCollection, String...)} call returns
     * <code>true</code>, <code>false</code> otherwise.
     */
    public boolean[] isPermitted(PrincipalCollection principals, String... permissions) {
        assertRealmsConfigured();
        if (permissions != null && permissions.length > 0) {
            boolean[] isPermitted = new boolean[permissions.length];
            for (int i = 0; i < permissions.length; i++) {
                isPermitted[i] = isPermitted(principals, permissions[i]);
            }
            return isPermitted;
        }
        return new boolean[0];
    }

    /**
     * Returns <code>true</code> if any of the configured realms'
     * {@link #isPermitted(org.apache.shiro.subject.PrincipalCollection, List)} call returns <code>true</code>,
     * <code>false</code> otherwise.
     */
    public boolean[] isPermitted(PrincipalCollection principals, List<Permission> permissions) {
        assertRealmsConfigured();
        if (permissions != null && !permissions.isEmpty()) {
            boolean[] isPermitted = new boolean[permissions.size()];
            int i = 0;
            for (Permission p : permissions) {
                isPermitted[i++] = isPermitted(principals, p);
            }
            return isPermitted;
        }

        return new boolean[0];
    }

    /**
     * Returns <code>true</code> if any of the configured realms'
     * {@link #isPermitted(org.apache.shiro.subject.PrincipalCollection, String)} call returns <code>true</code>
     * for <em>all</em> of the specified string permissions, <code>false</code> otherwise.
     */
    public boolean isPermittedAll(PrincipalCollection principals, String... permissions) {
        assertRealmsConfigured();
        if (permissions != null && permissions.length > 0) {
            for (String perm : permissions) {
                if (!isPermitted(principals, perm)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns <code>true</code> if any of the configured realms'
     * {@link #isPermitted(org.apache.shiro.subject.PrincipalCollection, Permission)} call returns <code>true</code>
     * for <em>all</em> of the specified Permissions, <code>false</code> otherwise.
     */
    public boolean isPermittedAll(PrincipalCollection principals, Collection<Permission> permissions) {
        assertRealmsConfigured();
        if (permissions != null && !permissions.isEmpty()) {
            for (Permission permission : permissions) {
                if (!isPermitted(principals, permission)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * If !{@link #isPermitted(org.apache.shiro.subject.PrincipalCollection, String) isPermitted(permission)}, throws
     * an <code>UnauthorizedException</code> otherwise returns quietly.
     */
    public void checkPermission(PrincipalCollection principals, String permission) throws AuthorizationException {
        assertRealmsConfigured();
        if (!isPermitted(principals, permission)) {
            throw new UnauthorizedException("Subject does not have permission [" + permission + "]");
        }
    }

    /**
     * If !{@link #isPermitted(org.apache.shiro.subject.PrincipalCollection, Permission) isPermitted(permission)}, throws
     * an <code>UnauthorizedException</code> otherwise returns quietly.
     */
    public void checkPermission(PrincipalCollection principals, Permission permission) throws AuthorizationException {
        assertRealmsConfigured();
        if (!isPermitted(principals, permission)) {
            throw new UnauthorizedException("Subject does not have permission [" + permission + "]");
        }
    }

    /**
     * If !{@link #isPermitted(org.apache.shiro.subject.PrincipalCollection, String...) isPermitted(permission)},
     * throws an <code>UnauthorizedException</code> otherwise returns quietly.
     */
    public void checkPermissions(PrincipalCollection principals, String... permissions) throws AuthorizationException {
        assertRealmsConfigured();
        if (permissions != null && permissions.length > 0) {
            for (String perm : permissions) {
                checkPermission(principals, perm);
            }
        }
    }

    /**
     * If !{@link #isPermitted(org.apache.shiro.subject.PrincipalCollection, Permission) isPermitted(permission)} for
     * <em>all</em> the given Permissions, throws
     * an <code>UnauthorizedException</code> otherwise returns quietly.
     */
    public void checkPermissions(PrincipalCollection principals, Collection<Permission> permissions) throws AuthorizationException {
        assertRealmsConfigured();
        if (permissions != null) {
            for (Permission permission : permissions) {
                checkPermission(principals, permission);
            }
        }
    }

    /**
     * Returns <code>true</code> if any of the configured realms'
     * {@link #hasRole(org.apache.shiro.subject.PrincipalCollection, String)} call returns <code>true</code>,
     * <code>false</code> otherwise.
     */
    public boolean hasRole(PrincipalCollection principals, String roleIdentifier) {
        assertRealmsConfigured();
        for (Realm realm : getRealms()) {
            if (!(realm instanceof Authorizer)) continue;
            if (((Authorizer) realm).hasRole(principals, roleIdentifier)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Calls {@link #hasRole(org.apache.shiro.subject.PrincipalCollection, String)} for each role name in the specified
     * collection and places the return value from each call at the respective location in the returned array.
     */
    public boolean[] hasRoles(PrincipalCollection principals, List<String> roleIdentifiers) {
        assertRealmsConfigured();
        if (roleIdentifiers != null && !roleIdentifiers.isEmpty()) {
            boolean[] hasRoles = new boolean[roleIdentifiers.size()];
            int i = 0;
            for (String roleId : roleIdentifiers) {
                hasRoles[i++] = hasRole(principals, roleId);
            }
            return hasRoles;
        }

        return new boolean[0];
    }

    /**
     * Returns <code>true</code> iff any of the configured realms'
     * {@link #hasRole(org.apache.shiro.subject.PrincipalCollection, String)} call returns <code>true</code> for
     * <em>all</em> roles specified, <code>false</code> otherwise.
     */
    public boolean hasAllRoles(PrincipalCollection principals, Collection<String> roleIdentifiers) {
        assertRealmsConfigured();
        for (String roleIdentifier : roleIdentifiers) {
            if (!hasRole(principals, roleIdentifier)) {
                return false;
            }
        }
        return true;
    }

    /**
     * If !{@link #hasRole(org.apache.shiro.subject.PrincipalCollection, String) hasRole(role)}, throws
     * an <code>UnauthorizedException</code> otherwise returns quietly.
     */
    public void checkRole(PrincipalCollection principals, String role) throws AuthorizationException {
        assertRealmsConfigured();
        if (!hasRole(principals, role)) {
            throw new UnauthorizedException("Subject does not have role [" + role + "]");
        }
    }

    /**
     * Calls {@link #checkRoles(PrincipalCollection principals, String... roles) checkRoles(PrincipalCollection principals, String... roles) }.
     */
    public void checkRoles(PrincipalCollection principals, Collection<String> roles) throws AuthorizationException {
        //SHIRO-234 - roles.toArray() -> roles.toArray(new String[roles.size()])
        if (roles != null && !roles.isEmpty()) checkRoles(principals, roles.toArray(new String[roles.size()]));
    }

    /**
     * Calls {@link #checkRole(org.apache.shiro.subject.PrincipalCollection, String) checkRole} for each role specified.
     */
    public void checkRoles(PrincipalCollection principals, String... roles) throws AuthorizationException {
        assertRealmsConfigured();
        if (roles != null) {
            for (String role : roles) {
                checkRole(principals, role);
            }
        }
    }
	
	public Map<String, Object> getDefinedRealms() {
		return this.definedRealms;
	}

	public void setDefinedRealms(Map<String, Object> definedRealms) {
		this.definedRealms = definedRealms;
	}
}

package com.example.demo.config;

import com.google.common.base.Strings;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 自定义实现Realm，测试用
 */
public class CustomRealm extends AuthorizingRealm {

    Map<String, String> userMap = new HashMap<>(16);

    {
        userMap.put("aaa", "123456");
        userMap.put("bbb", "123456");
        super.setName("CustomRealm");
    }

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = (String) principals.getPrimaryPrincipal();
        /**
         * 从数据库或缓存中获取角色权限
         */
        Set<String> roles = getRolesByUserName(userName);
        Set<String> permissions = getPermissionsByUserName(userName);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    private Set<String> getRolesByUserName(String userName) {
        Set<String> roles = new HashSet<>();
        roles.add("admin");
        roles.add("user");
        return roles;
    }

    private Set<String> getPermissionsByUserName(String userName) {
        Set<String> roles = new HashSet<>();
        roles.add("user:delete");
        roles.add("user:add");
        return roles;
    }

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 1.从主体传过来的认证信息中获得用户名
        String userName = (String) token.getPrincipal();
        // 2.通过用户名到数据库获得凭证
        String password = getPasswordByUsername(userName);
        if (Strings.isNullOrEmpty(password)) return null;

        return new SimpleAuthenticationInfo(userName, password, "CustomRealm");
    }

    /**
     * 模拟数据库查询凭证
     *
     * @param username
     * @return
     */
    private String getPasswordByUsername(String username) {
        return userMap.get(username);
    }
}

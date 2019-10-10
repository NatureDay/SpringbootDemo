package com.example.demo.config;

import com.example.demo.base.CommonException;
import com.example.demo.model.Permission;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.util.JsonUtil;
import com.example.demo.util.LogUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Shiro认证授权自定义实现
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        LogUtil.info("--------doGetAuthorizationInfo----------" + JsonUtil.toJson(principalCollection));
        String account = (String) principalCollection.getPrimaryPrincipal();
        /**
         * 从数据库或缓存中获取角色权限
         */
        User user = userService.queryUserByAccount(account);
        Set<String> roles = getRolesByAccount(user);
        Set<String> permissions = getPermissionsByAccount(user);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    private Set<String> getRolesByAccount(User user) {
        if (user != null) {
            if (user.getRole() != null) {
                Set<String> roles = new HashSet<>();
                roles.add(user.getRole().getRoleName());
                return roles;
            }
        }
        return null;
    }

    private Set<String> getPermissionsByAccount(User user) {
        if (user != null) {
            List<Permission> permissions = user.getPermissions();
            if (user.getPermissions() != null) {
                Set<String> pers = new HashSet<>();
                for (Permission permission : permissions) {
                    pers.add(permission.getPerName());
                }
                return pers;
            }
        }
        return null;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        LogUtil.info("--------doGetAuthenticationInfo----------" + JsonUtil.toJson(authenticationToken));
        // 1.从主体传过来的认证信息中获得用户名
        String account = (String) authenticationToken.getPrincipal();
        // 2.通过用户名到数据库获得凭证
        User user = userService.queryUserByAccount(account);
        if (user == null) throw CommonException.create(666, "未找到此用户");
        return new SimpleAuthenticationInfo(user.getAccount(), user.getPassword(), getName());
    }

}

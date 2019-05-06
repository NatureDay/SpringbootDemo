package com.example.demo.config;

import com.example.demo.util.JsonUtil;
import com.example.demo.util.LogUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Shiro认证授权自定义实现
 */
public class ShiroRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        LogUtil.info("--------doGetAuthorizationInfo----------" + JsonUtil.toJson(principalCollection));
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        LogUtil.info("--------doGetAuthenticationInfo----------" + JsonUtil.toJson(authenticationToken));
        return null;
    }
}

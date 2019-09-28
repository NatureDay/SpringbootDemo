package com.example.demo.config;

import com.example.demo.base.CommonException;
import com.example.demo.model.UserEntity;
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

        String userName = (String) principalCollection.getPrimaryPrincipal();
        /**
         * 从数据库或缓存中获取角色权限
         */
//        Set<String> roles = getRolesByUserName(userName);
//        Set<String> permissions = getPermissionsByUserName(userName);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        simpleAuthorizationInfo.setRoles(roles);
//        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
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
        String userName = (String) authenticationToken.getPrincipal();
        // 2.通过用户名到数据库获得凭证
        UserEntity userEntity = userService.getUserByUsername(userName);
        if (userEntity == null) throw CommonException.create(666, "未找到此用户");
        return new SimpleAuthenticationInfo(userEntity.getName(), userEntity.getPassword(), getName());
    }

}

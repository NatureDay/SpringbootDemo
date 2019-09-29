package com.example.demo.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro认证授权自定义实现
 * <p>
 * anon:
 * 例子/admins/**=anon 没有参数，表示可以匿名使用。
 * <p>
 * authc:
 * 例如/admins/user/**=authc表示需要认证(登录)才能使用，没有参数
 * <p>
 * roles(角色)：
 * 例子/admins/user/**=roles[admin],参数可以写多个，参数之间用逗号分割，当有多个参数时，例如admins/user/**=roles["admin,guest"],每个参数通过才算通过，相当于hasAllRoles()方法。
 * <p>
 * perms（权限）：
 * 例子/admins/user/**=perms[add],参数可以写多个，例如/admins/user/**=perms["add, modify"]，当有多个参数时必须每个参数都通过才通过，想当于isPermitedAll()方法。
 * <p>
 * rest：
 * 例子/admins/user/**=rest[user],根据请求的方法，相当于/admins/user/**=perms[user:method] ,其中method为post，get，delete等。
 * <p>
 * port：
 * 例子/admins/user/**=port[8081],当请求的url的端口不是8081是跳转到schemal://serverName:8081?queryString,其中schmal是协议http或https等，serverName是你访问的host,8081是url配置里port的端口，queryString
 * 是你访问的url里的？后面的参数。
 * <p>
 * authcBasic：
 * 例如/admins/user/**=authcBasic没有参数.表示httpBasic认证
 * <p>
 * ssl:
 * 例子/admins/user/**=ssl没有参数，表示安全的url请求，协议为https
 * <p>
 * user:
 * <p>
 * 例如/admins/user/**=user没有参数表示必须存在用户，当登入操作时不做检查
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroRealm shiroRealm() {
        return new ShiroRealm();
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        defaultSecurityManager.setRealm(shiroRealm());
        return defaultSecurityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/user/*", "authc");
        filterChainDefinitionMap.put("/user/update", "roles[user]");
        filterChainDefinitionMap.put("/user/delete", "perms[Delete]");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

}

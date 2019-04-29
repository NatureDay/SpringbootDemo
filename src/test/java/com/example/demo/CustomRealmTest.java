package com.example.demo;

import com.example.demo.config.CustomRealm;
import com.example.demo.util.LogUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomRealmTest {

    @Test
    public void testAuthentication() {

        CustomRealm customRealm = new CustomRealm();

        // 1.构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(customRealm);

        // 2.主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("aaa", "123456");
        subject.login(usernamePasswordToken);

        LogUtil.info("-------isAuthenticated-------" + subject.isAuthenticated());
        LogUtil.info("-------hasRole-------" + subject.hasRole("admin"));
        LogUtil.info("-------isPermitted-------" + subject.isPermitted("user:delete"));
    }
}

package shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * desc:shiro使用ini文件存储用户信息登录
 * @author hy
 * @version 1.0
 * @Created on 2017/10/20 15:38
 */
public class ShiroSimpleLoginTest {
    private static final Logger logger = LoggerFactory.getLogger(ShiroSimpleLoginTest.class);

    @Test
    public void simpleLoginTest() {
        //初始化SecurityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            logger.error("登录失败");
            return;
        }
        if (logger.isInfoEnabled()) {
            logger.info("登录成功");
        }
        Assert.assertTrue(subject.isAuthenticated());


        subject.logout();

    }

}

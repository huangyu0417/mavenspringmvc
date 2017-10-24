package shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2017/10/24 10:31
 */
public class MyRealm implements Realm {
    private static final Logger logger = LoggerFactory.getLogger(MyRealm.class);

    @Override
    public String getName() {
        return "MyRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        if (logger.isDebugEnabled()) {
            logger.debug("=============={{}}==========",getName());
        }
        String user = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        if (logger.isInfoEnabled()) {
            logger.info("============user{{}},password{{}}=============",user,password);
        }

        return new SimpleAuthenticationInfo(user,password,getName());
    }
}

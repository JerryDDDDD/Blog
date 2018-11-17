package com.layman.shiro.realm;

import com.layman.background.dao.UserDao;
import com.layman.background.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomerRealm extends AuthorizingRealm {
    @Resource
    private UserDao userDao;

    // authorization: 授权
    // principal: 已经鉴定过的使用者
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = (String) principals.getPrimaryPrincipal();
        Set<String> roles = getRolesByUserName(userName);
        Set<String> permissions = new HashSet<String>();

        for (String role:roles){
            Set<String> permission = getPermissionsByRole(role);
            for (String per : permission){
                permissions.add(per);
            }
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(permissions);
        simpleAuthorizationInfo.addRoles(roles);

        return simpleAuthorizationInfo;
    }



    // authentication: 身份认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        // 1. 从主体传过来的认证信息中，获取用户名
        String username = (String) token.getPrincipal();

        // 2. 通过用户名到数据库中获取凭证
        String password = getPasswordByUserName(username);

        if(password == null){
            return null;
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username,password,"customRealm");

        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(username));
        return simpleAuthenticationInfo;
    }

    // 模拟数据库
    private String getPasswordByUserName(String username) {
        User user = userDao.getUserByUserName(username);
        if (user != null){
            System.out.println(user.getPassword());
            return user.getPassword();
        }
        return null;
    }

    private Set<String> getPermissionByUserName(String userName) {
        List<String> list = userDao.queryPermissionByUserName(userName);
        Set<String> sets = new HashSet<String>(list);
        System.out.println(sets.toString());
        return  sets;
    }

    private Set<String> getRolesByUserName(String userName) {
        List<String> list = userDao.queryRolesByUserName(userName);
        Set<String> sets = new HashSet<String>(list);
        return sets;
    }

    private Set<String> getPermissionsByRole(String role){
        List<String> list = userDao.getPermissionsByRole(role);
        Set<String> sets = new HashSet<String>(list);
        return sets;
    }
}

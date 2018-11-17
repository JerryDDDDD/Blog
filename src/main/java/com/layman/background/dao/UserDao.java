package com.layman.background.dao;

import com.layman.background.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    String queryPasswordByUsername(String username);

    User getUserByUserName(String username);

    List<String> queryPermissionByUserName(String userName);

    List<String> queryRolesByUserName(String userName);

    List<String> getPermissionsByRole(String role);
}

package com.layman.background.dao;

import com.layman.background.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    String queryPasswordByUsername(String username);
}

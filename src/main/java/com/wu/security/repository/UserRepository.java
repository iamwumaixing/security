package com.wu.security.repository;

import com.wu.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * jpa操作类
 *
 * @author Qwu
 */
public interface UserRepository extends JpaRepository<User,Long> {
    /**
     * 通过用户名查找用户实体
     * @param username
     * @return
     */
    User findByUsername(String username);
}

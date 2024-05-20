package com.elevengroup.watch.repository;

import com.elevengroup.watch.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "SELECT * FROM user WHERE username = ?1", nativeQuery = true)
    public User findByUserName(String username);
}

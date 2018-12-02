package com.example.first.repository;

import com.example.first.dto.FindOneByEmailRequest;
import com.example.first.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    User findOneByEmail(String login);

}

package com.nuuuri.backend.data.repository;

import com.nuuuri.backend.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

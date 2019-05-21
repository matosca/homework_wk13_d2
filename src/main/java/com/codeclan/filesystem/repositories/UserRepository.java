package com.codeclan.filesystem.repositories;

import com.codeclan.filesystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

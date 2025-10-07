package com.Login.repository;

import com.Login.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
	Login findByUsername(String username);

}

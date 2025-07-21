package com.thrivepal.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thrivepal.userservice.model.UserData;

@Repository
public interface UserRepository extends JpaRepository<UserData, Long> {
	Optional<UserData> findByEmail(String email);
}

package com.santt4na.rapidinner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santt4na.rapidinner.model.accountTypes.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

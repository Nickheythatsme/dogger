package com.dogger.platform.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select u from User u where u.fullName = ?1")
    List<User> findByFullName(String fullName);

}

package com.shr.food.place.persistence.repository;

import com.shr.food.place.base.exception.SWException;
import com.shr.food.place.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author MSA
 * @version 1.0
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    User findByEmailAddress(String emailAddress) throws SWException;
}
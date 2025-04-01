package com.shr.food.place.persistence.repository;

import com.shr.food.place.base.exception.SWException;
import com.shr.food.place.persistence.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author MSA
 * @version 1.0
 */

@Repository
public interface UserCredentialRepository extends JpaRepository<UserCredential, Long>, JpaSpecificationExecutor<UserCredential> {
    @Query("SELECT uc FROM UserCredential uc WHERE uc.user.id = ?1 AND uc.status = 1")
    List<UserCredential> findCredentialByUserId(Long userId) throws SWException;
}
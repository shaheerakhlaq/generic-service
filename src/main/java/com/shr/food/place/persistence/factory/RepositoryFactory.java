package com.shr.food.place.persistence.factory;

import com.shr.food.place.persistence.repository.OrganizationRepository;
import com.shr.food.place.persistence.repository.UserCredentialRepository;
import com.shr.food.place.persistence.repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author MSA
 * @version 1.0
 */

@Getter
@RequiredArgsConstructor
@Component
public class RepositoryFactory implements Serializable {
    private final UserRepository userRepository;
    private final UserCredentialRepository userCredentialRepository;
    private final OrganizationRepository organizationRepository;
}
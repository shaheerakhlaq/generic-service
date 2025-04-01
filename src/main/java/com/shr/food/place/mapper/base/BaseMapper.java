package com.shr.food.place.mapper.base;

import com.shr.food.place.base.exception.SWException;
import com.shr.food.place.base.util.SWDateUtil;
import com.shr.food.place.mapper.generic.GenericMapper;
import com.shr.food.place.persistence.entity.BaseEntity;
import com.shr.food.place.persistence.repository.OrganizationRepository;
import com.shr.food.place.persistence.repository.UserCredentialRepository;
import com.shr.food.place.persistence.repository.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author MSA
 * @version 1.0
 */

@Getter
public abstract class BaseMapper<E, M> implements GenericMapper<E, M> {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserCredentialRepository userCredentialRepository;
    @Autowired
    private OrganizationRepository organizationRepository;

    /**
     * Add audit information
     *
     * @param entity
     */
    protected void addAuditInformation(BaseEntity entity) throws SWException {
        if (entity.getId() == null) {
            entity.setCreatedBy(1L); // Login in user id will be set
            entity.setCreatedDate(SWDateUtil.getCurrentLocalDateTime());
        } else {
            entity.setModifiedBy(1L);
            entity.setModifiedDate(SWDateUtil.getCurrentLocalDateTime());
        }
    }
}
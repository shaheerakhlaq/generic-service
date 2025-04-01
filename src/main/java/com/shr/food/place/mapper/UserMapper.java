package com.shr.food.place.mapper;

import com.shr.food.place.base.dto.request.AddUserRequestDTO;
import com.shr.food.place.base.dto.response.UserResponseDTO;
import com.shr.food.place.base.exception.SWException;
import com.shr.food.place.base.util.SWUtil;
import com.shr.food.place.mapper.base.BaseMapper;
import com.shr.food.place.persistence.entity.User;
import com.shr.food.place.persistence.entity.UserCredential;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Component
public class UserMapper extends BaseMapper<User, UserResponseDTO> {
    public Class<User> getEntityType() {
        return User.class;
    }

    /**
     * Add user
     *
     * @param requestDto
     * @return User
     * @throws SWException
     */
    public User add(AddUserRequestDTO requestDto) throws SWException {
        User entity = new User();
        entity.setOrganization(getOrganizationRepository().getReferenceById(requestDto.getOrganizationId()));
        entity.setEmailAddress(requestDto.getEmailAddress());
        entity.setFirstName(requestDto.getFirstName());
        entity.setLastName(requestDto.getLastName());
        entity.setPhoneNumber(requestDto.getPhoneNumber());
        entity.setStatus(requestDto.getStatus());

        addAuditInformation(entity);

        return entity;
    }

    /**
     * Add user credentials
     *
     * @param requestDto
     * @param user
     * @return UserCredential
     * @throws SWException
     */
    public UserCredential addUserCredential(AddUserRequestDTO requestDto, User user) throws SWException {
        UserCredential entity = new UserCredential();
        entity.setUser(user);
        entity.setCredential(requestDto.getPassword());
        entity.setStatus(requestDto.getStatus());

        addAuditInformation(entity);

        return entity;
    }

    /**
     * Find User
     *
     * @param entity
     * @return User
     * @throws SWException
     */
    public UserResponseDTO find(User entity) throws SWException {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setUserId(entity.getId());
        dto.setEmailAddress(entity.getEmailAddress());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setStatus(SWUtil.getStatus(entity.getStatus()));

        return dto;
    }
}
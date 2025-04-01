package com.shr.food.place.mapper;

import com.shr.food.place.base.dto.request.AddOrganizationRequestDTO;
import com.shr.food.place.base.dto.request.UpdateOrganizationRequestDTO;
import com.shr.food.place.base.dto.response.OrganizationResponseDTO;
import com.shr.food.place.base.exception.SWException;
import com.shr.food.place.base.util.SWConstants;
import com.shr.food.place.base.util.SWHelper;
import com.shr.food.place.base.util.SWStatusConstants;
import com.shr.food.place.base.util.SWUtil;
import com.shr.food.place.mapper.base.BaseMapper;
import com.shr.food.place.persistence.entity.Organization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Component
public class OrganizationMapper extends BaseMapper<Organization, OrganizationResponseDTO> {
    public Class<Organization> getEntityType() {
        return Organization.class;
    }

    /**
     * Add
     *
     * @param requestDto
     * @return Organization
     * @throws SWException
     */
    public Organization add(AddOrganizationRequestDTO requestDto) throws SWException {
        Organization entity = new Organization();
        entity.setCode(requestDto.getCode());
        entity.setName(requestDto.getCode());
        entity.setAddress(requestDto.getCode());
        entity.setPhoneNumber(requestDto.getCode());
        entity.setEmailAddress(requestDto.getEmailAddress());
        entity.setStatus(requestDto.getStatus());

        addAuditInformation(entity);

        return entity;
    }

    /**
     * Update
     *
     * @param requestDto
     * @return Organization
     * @throws SWException
     */
    public Organization update(UpdateOrganizationRequestDTO requestDto) throws SWException {
        Organization entity = getOrganizationRepository().findById(requestDto.getOrganizationId())
                .orElseThrow(() -> SWHelper.handleOptionalSWException(SWStatusConstants.Status.CODE_RESULT_NOT_FOUND, SWStatusConstants.Status.MSG_RESULT_NOT_FOUND));

        entity.setCode(requestDto.getCode());
        entity.setName(requestDto.getCode());
        entity.setAddress(requestDto.getCode());
        entity.setPhoneNumber(requestDto.getCode());
        entity.setEmailAddress(requestDto.getEmailAddress());
        entity.setStatus(requestDto.getStatus());

        addAuditInformation(entity);

        return entity;
    }

    /**
     * Delete
     *
     * @param OrganizationId
     * @return Organization
     * @throws SWException
     */
    public Organization delete(Long OrganizationId) throws SWException {
        Organization entity = getOrganizationRepository().findById(OrganizationId)
                .orElseThrow(() -> SWHelper.handleOptionalSWException(SWStatusConstants.Status.CODE_RESULT_NOT_FOUND,
                        SWStatusConstants.Status.MSG_RESULT_NOT_FOUND));

        entity.setStatus(SWConstants.Status.CODE_DELETE);

        addAuditInformation(entity);

        return entity;
    }

    /**
     * Find
     *
     * @param entity
     * @return OrganizationResponseDTO
     * @throws SWException
     */
    public OrganizationResponseDTO find(Organization entity) throws SWException {
        return OrganizationResponseDTO
                .builder()
                .organizationId(entity.getId())
                .name(entity.getName())
                .code(entity.getCode())
                .address(entity.getAddress())
                .phoneNumber(entity.getPhoneNumber())
                .emailAddress(entity.getEmailAddress())
                .status(SWUtil.getStatus(entity.getStatus()))
                .build();
    }
}
package com.shr.food.place.controller;

import com.shr.food.place.base.dto.request.AddOrganizationRequestDTO;
import com.shr.food.place.base.dto.request.SearchCriteriaRequestDTO;
import com.shr.food.place.base.dto.response.SearchResultResponseDTO;
import com.shr.food.place.base.dto.response.base.BaseResponseDTO;
import com.shr.food.place.base.exception.SWException;
import com.shr.food.place.controller.base.BaseController;
import com.shr.food.place.persistence.entity.Organization;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MSA
 * @version 1.0
 */

@RestController
@RequestMapping("/api/v_1/organization")
public class OrganizationController extends BaseController {
    /**
     * Create organization
     *
     * @param requestDto
     * @return BaseResponseDTO
     * @throws SWException
     */
    @PostMapping("/add")
    public BaseResponseDTO add(@RequestBody AddOrganizationRequestDTO requestDto) throws SWException {
        Organization entity = getOrganizationMapper().add(requestDto);

        getOrganizationService().insert(entity);

        return response();
    }

    /**
     * Find
     *
     * @param requestDto
     * @return BaseResponseDTO<SearchResultResponseDTO>
     * @throws SWException
     */
    @PostMapping("/find")
    public BaseResponseDTO<SearchResultResponseDTO> find(@RequestBody SearchCriteriaRequestDTO requestDto) throws SWException {
        SearchResultResponseDTO responseDto = getOrganizationService().search(requestDto);

        return response(responseDto);
    }
}
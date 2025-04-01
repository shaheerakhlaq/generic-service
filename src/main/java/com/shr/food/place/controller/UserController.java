package com.shr.food.place.controller;

import com.shr.food.place.base.dto.request.AddUserRequestDTO;
import com.shr.food.place.base.dto.request.SearchCriteriaRequestDTO;
import com.shr.food.place.base.dto.response.SearchResultResponseDTO;
import com.shr.food.place.base.dto.response.UserResponseDTO;
import com.shr.food.place.base.dto.response.base.BaseResponseDTO;
import com.shr.food.place.base.exception.SWException;
import com.shr.food.place.controller.base.BaseController;
import com.shr.food.place.persistence.entity.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author MSA
 * @version 1.0
 */

@RestController
@RequestMapping("/api/v_1/user")
public class UserController extends BaseController {
    /**
     * Create user
     *
     * @param requestDto
     * @return BaseResponseDTO
     * @throws SWException
     */
    @PostMapping("/add")
    public BaseResponseDTO add(@RequestBody AddUserRequestDTO requestDto) throws SWException {
        getUserService().addUser(requestDto);

        return response();
    }

    /**
     * Find
     *
     * @param userId
     * @return BaseResponseDTO<SearchResultResponseDTO>
     * @throws SWException
     */
    @GetMapping("/find/{userId}")
    public BaseResponseDTO<UserResponseDTO> find(@PathVariable Long userId) throws SWException {
        User entity = getUserService().findByEntityId(userId);

        UserResponseDTO responseDto = getUserMapper().find(entity);

        return response(responseDto);
    }

    /**
     * Find
     *
     * @param requestDto
     * @return BaseResponseDTO<SearchResultResponseDTO>
     * @throws SWException
     */
    //@ElkLog(endpointName = "User", serviceName = "find")
    @PostMapping("/find")
    public BaseResponseDTO<SearchResultResponseDTO> find(@RequestBody SearchCriteriaRequestDTO requestDto) throws SWException {
        SearchResultResponseDTO responseDto = getUserService().find(requestDto);

        return response(responseDto);
    }
}
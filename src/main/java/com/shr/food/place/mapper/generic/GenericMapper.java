package com.shr.food.place.mapper.generic;

import com.shr.food.place.base.exception.SWException;

/**
 * @author MSA
 * @version 1.0
 */

public interface GenericMapper<E, M> {
    M find(E entity) throws SWException;

    Class<E> getEntityType();
}
package com.shr.food.place.mapper.factory;

import com.shr.food.place.base.exception.SWException;
import com.shr.food.place.mapper.generic.GenericMapper;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author MSA
 * @version 1.0
 */

@Getter
@Component
public class MapperFactory implements Serializable {
    private final Map<Class<?>, GenericMapper<?, ?>> mapperMap = new HashMap<>();

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void init() {
        // Retrieve all beans of type GenericMapper and register them
        Map<String, GenericMapper> mappers = applicationContext.getBeansOfType(GenericMapper.class);

        for (GenericMapper<?, ?> mapper : mappers.values()) {
            Class<?> entityType = mapper.getEntityType(); // Assume GenericMapper has getEntityType() method

            if (entityType != null) {
                mapperMap.put(entityType, mapper);
            }
        }
    }

    /**
     * Get mapper object
     *
     * @param <E> Entity type parameter.
     * @param <R> DTO type parameter.
     * @return GenericMapper: A generic mapper instance for entity-to-DTO conversion.
     * @throws SWException
     */
    public <E, R> GenericMapper<E, R> getMapper(Class<E> type) throws SWException {
        GenericMapper<?, ?> mapper = mapperMap.get(type);

        if (mapper == null) {
            throw new SWException("Mapper not found for type: " + type.getName());
        }

        return (GenericMapper<E, R>) mapper;
    }
}
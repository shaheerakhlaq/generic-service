package com.shr.food.place.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "int_status", nullable = false, length = 2)
    private Integer status;

    @JsonIgnore
    @CreatedBy
    @Column(name = "int_created_by", updatable = false)
    private Long createdBy;

    @JsonIgnore
    @CreatedDate
    @Column(name = "dat_created_date", updatable = false)
    private LocalDateTime createdDate;

    @JsonIgnore
    @LastModifiedBy
    @Column(name = "int_modified_by", insertable = false)
    private Long modifiedBy;

    @JsonIgnore
    @LastModifiedDate
    @Column(name = "dat_modified_date", insertable = false)
    private LocalDateTime modifiedDate;
}
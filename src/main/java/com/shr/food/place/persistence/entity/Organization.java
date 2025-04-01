package com.shr.food.place.persistence.entity;

import com.shr.food.place.persistence.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@Entity
@Table(name = "sw_organizations")
@EqualsAndHashCode(callSuper = true)
public class Organization extends BaseEntity {
    @Column(name = "str_name", nullable = false, length = 80)
    private String name;

    @Column(name = "str_code", nullable = false, length = 80)
    private String code;

    @Column(name = "str_address", nullable = false, length = 80)
    private String address;

    @Column(name = "str_phone_number", nullable = false, length = 80)
    private String phoneNumber;

    @Column(name = "str_email_address", nullable = false, length = 80)
    private String emailAddress;
}
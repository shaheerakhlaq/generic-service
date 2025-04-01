package com.shr.food.place.persistence.entity;

import com.shr.food.place.persistence.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@Entity
@Table(name = "sw_users")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_organization", nullable = false)
    private Organization organization;

    @Column(name = "str_first_name", nullable = false, length = 80)
    private String firstName;

    @Column(name = "str_last_name", nullable = false, length = 80)
    private String lastName;

    @Column(name = "str_email_address", nullable = false, length = 80)
    private String emailAddress;

    @Column(name = "str_phone_number", nullable = false, length = 80)
    private String phoneNumber;
}
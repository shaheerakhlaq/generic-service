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
@Table(name = "sw_user_credentials")
@EqualsAndHashCode(callSuper = true)
public class UserCredential extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "str_credential", nullable = false, length = 80)
    private String credential;
}
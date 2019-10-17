package com.wu.security.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Qwu
 */
@Entity
@Data
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
}

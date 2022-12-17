/*
 @author: lateef
 @project: digitalashram
 @created: 16/12/2022 - 7:27 pm
 */
package com.digitalashram.role.entity;

import com.digitalashram.core.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "da_role")
public class Role extends BaseEntity {
    /** The role title. */
    @Column(name = "ROLE_TITLE")
    private String roleTitle;

    /** The role desc. */
    @Column(name = "ROLE_DESC")
    private String roleDesc;


}

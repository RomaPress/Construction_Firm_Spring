package com.roman.pres.constructionfirm.bean.persistence;

import com.roman.pres.constructionfirm.constants.DBConstants;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = DBConstants.ROLE_TABLE)
public class UserRoleBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(unique = true)
    private String name;

    public UserRoleBean() {
    }

    public UserRoleBean(@NotEmpty String name) {
        this.name = name;
    }
}

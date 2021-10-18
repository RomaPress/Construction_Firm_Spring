package com.roman.pres.constructionfirm.bean.persistence;

import com.roman.pres.constructionfirm.constants.DBConstants;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = DBConstants.USER_TABLE)
public class UserBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = DBConstants.ROLE_ID_COLUMN)
    private UserRoleBean role;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String patronymic;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    @Column(unique = true)
    private String login;

    @NotEmpty
    private String password;

    private String address;

    public UserBean() {
    }

    public UserBean(UserRoleBean role, @NotEmpty String firstName, @NotEmpty String lastName, @NotEmpty String patronymic,
                    @NotEmpty String phoneNumber, String address, @NotEmpty String login, @NotEmpty String password) {
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.login = login;
        this.password = password;
    }
}

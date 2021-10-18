package com.roman.pres.constructionfirm.bean.persistence;

import com.roman.pres.constructionfirm.constants.DBConstants;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = DBConstants.SERVICE_CLASSIFICATION_TABLE)
public class ServiceClassificationBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(unique = true)
    private String name;

    public ServiceClassificationBean() {
    }

    public ServiceClassificationBean(@NotEmpty String name) {
        this.name = name;
    }

}

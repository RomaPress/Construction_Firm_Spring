package com.roman.pres.constructionfirm.bean.persistence;

import com.roman.pres.constructionfirm.constants.DBConstants;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = DBConstants.UNIT_TABLE)
public class UnitBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(unique = true)
    private String name;

    public UnitBean() {
    }

    public UnitBean(@NotEmpty String name) {
        this.name = name;
    }

}

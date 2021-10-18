package com.roman.pres.constructionfirm.bean.persistence;

import com.roman.pres.constructionfirm.constants.DBConstants;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = DBConstants.MATERIAL_TYPE_TABLE)
public class MaterialTypeBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(unique = true)
    private String name;

    public MaterialTypeBean(@NotEmpty String name) {
        this.name = name;
    }

    public MaterialTypeBean() {
    }
}

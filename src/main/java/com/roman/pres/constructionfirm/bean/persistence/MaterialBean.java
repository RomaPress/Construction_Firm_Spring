package com.roman.pres.constructionfirm.bean.persistence;

import com.roman.pres.constructionfirm.constants.DBConstants;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Set;


@Entity
@Setter
@Getter
@Data
@Table(name = DBConstants.MATERIAL_TABLE)
public class MaterialBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = DBConstants.MATERIAL_TYPE_ID_COLUMN)
    private MaterialTypeBean materialType;

    @NotEmpty
    @Column(unique = true)
    private String name;

    @NotEmpty
    private BigDecimal price;

    @OneToMany(mappedBy = DBConstants.MATERIAL, cascade = CascadeType.ALL)
    private Set<ServiceMaterialEstimateBean> serviceMaterialEstimateBeans;

    public MaterialBean(MaterialTypeBean materialType, @NotEmpty String name, @NotEmpty BigDecimal price) {
        this.materialType = materialType;
        this.name = name;
        this.price = price;
    }

    public MaterialBean() {
    }
}

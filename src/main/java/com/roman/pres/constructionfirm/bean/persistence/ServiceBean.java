package com.roman.pres.constructionfirm.bean.persistence;

import com.roman.pres.constructionfirm.constants.DBConstants;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@Table(name = DBConstants.SERVICE_TABLE)
public class ServiceBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = DBConstants.SERVICE_CLASSIFICATION_ID_COLUMN)
    private ServiceClassificationBean classification;

    @ManyToOne
    @JoinColumn(name = DBConstants.UNIT_ID_COLUMN)
    private UnitBean unit;

    @NotEmpty
    @Column(unique = true)
    private String name;

    @NotEmpty
    private BigDecimal price;

    @OneToMany(mappedBy = DBConstants.SERVICE, cascade = CascadeType.ALL)
    private Set<ServiceMaterialEstimateBean> serviceMaterialEstimateBeans;


    public ServiceBean() {
    }

    public ServiceBean(ServiceClassificationBean classification, UnitBean unit, @NotEmpty String name,
                       @NotEmpty BigDecimal price, Set<ServiceMaterialEstimateBean> serviceMaterialEstimateBeans) {
        this.classification = classification;
        this.unit = unit;
        this.name = name;
        this.price = price;
        this.serviceMaterialEstimateBeans = serviceMaterialEstimateBeans;
    }
}

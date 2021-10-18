package com.roman.pres.constructionfirm.bean.persistence;

import com.roman.pres.constructionfirm.constants.DBConstants;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = DBConstants.SERVICE_MATERIAL_ESTIMATE_TABLE)
public class ServiceMaterialEstimateBean implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = DBConstants.SERVICE_ID_COLUMN)
    private ServiceBean service;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = DBConstants.MATERIAL_ID_COLUMN)
    private MaterialBean material;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = DBConstants.ESTIMATE_ID_COLUMN)
    private EstimateBean estimate;

    @ManyToOne
    @JoinColumn(name = DBConstants.STATUS_ID_COLUMN)
    private StatusBean status;

    private BigDecimal servicePrice;

    private BigDecimal materialPrice;

    private Integer serviceAmount;

    private Integer materialAmount;


}

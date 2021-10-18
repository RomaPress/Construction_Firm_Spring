package com.roman.pres.constructionfirm.bean.persistence;

import com.roman.pres.constructionfirm.constants.DBConstants;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

@Data
@Entity
@Table(name = DBConstants.ESTIMATE_TABLE)
public class EstimateBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = DBConstants.ORDER_ID_COLUMN)
    private OrderBean order;

    @ManyToOne
    @JoinColumn(name = DBConstants.STATUS_ID_COLUMN)
    private StatusBean status;

    @NotEmpty
    private String name;

    @NotEmpty
    private BigDecimal total;

    @CreationTimestamp
    private Timestamp createTime;

    @UpdateTimestamp
    private Timestamp changeTime;

    @OneToMany(mappedBy = DBConstants.ESTIMATE, cascade = CascadeType.ALL)
    private Set<ServiceMaterialEstimateBean> serviceMaterialEstimateBeans;

    public EstimateBean() {
    }

    public EstimateBean(OrderBean order, StatusBean status, @NotEmpty String name, @NotEmpty BigDecimal total,
                        Timestamp createTime, Timestamp changeTime) {
        this.order = order;
        this.status = status;
        this.name = name;
        this.total = total;
        this.createTime = createTime;
        this.changeTime = changeTime;
    }

}


package com.roman.pres.constructionfirm.bean.persistence;

import com.roman.pres.constructionfirm.constants.DBConstants;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = DBConstants.ORDER_TABLE)
public class OrderBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = DBConstants.STATUS_ID_COLUMN)
    private StatusBean status;

    @ManyToOne
    @JoinColumn(name = DBConstants.USER_ID_COLUMN)
    private UserBean user;

    @CreationTimestamp
    private Timestamp createTime;

    public OrderBean() {
    }

    public OrderBean(StatusBean status, UserBean user, Timestamp createTime) {
        this.status = status;
        this.user = user;
        this.createTime = createTime;
    }
}

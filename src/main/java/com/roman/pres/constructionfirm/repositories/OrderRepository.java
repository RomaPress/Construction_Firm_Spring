package com.roman.pres.constructionfirm.repositories;

import com.roman.pres.constructionfirm.bean.persistence.OrderBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderBean, Long> {
}

package com.roman.pres.constructionfirm.repositories;

import com.roman.pres.constructionfirm.bean.persistence.EstimateBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstimateRepository extends JpaRepository<EstimateBean, Long> {
}

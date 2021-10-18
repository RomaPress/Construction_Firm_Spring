package com.roman.pres.constructionfirm.repositories;

import com.roman.pres.constructionfirm.bean.persistence.ServiceBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceBean, Long> {
}

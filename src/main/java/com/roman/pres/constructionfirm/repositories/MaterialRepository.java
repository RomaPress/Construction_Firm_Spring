package com.roman.pres.constructionfirm.repositories;

import com.roman.pres.constructionfirm.bean.persistence.MaterialBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<MaterialBean, Long> {
}

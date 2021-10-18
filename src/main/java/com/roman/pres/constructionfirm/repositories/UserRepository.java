package com.roman.pres.constructionfirm.repositories;

import com.roman.pres.constructionfirm.bean.persistence.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserBean, Long> {
}

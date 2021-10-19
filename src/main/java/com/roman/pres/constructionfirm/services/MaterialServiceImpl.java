package com.roman.pres.constructionfirm.services;

import com.roman.pres.constructionfirm.bean.persistence.MaterialBean;
import com.roman.pres.constructionfirm.repositories.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;

    @Autowired
    public MaterialServiceImpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public List<MaterialBean> getAllMaterials() {
        return materialRepository.findAll();
    }
}

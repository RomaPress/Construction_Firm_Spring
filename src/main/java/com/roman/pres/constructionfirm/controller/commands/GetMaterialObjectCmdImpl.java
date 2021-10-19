package com.roman.pres.constructionfirm.controller.commands;

import com.roman.pres.constructionfirm.bean.persistence.MaterialBean;
import com.roman.pres.constructionfirm.bean.persistence.MaterialTypeBean;
import com.roman.pres.constructionfirm.command.ControllerCommandImpl;
import com.roman.pres.constructionfirm.services.MaterialService;
import com.roman.pres.constructionfirm.services.MaterialServiceImpl;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Controller
public class GetMaterialObjectCmdImpl extends ControllerCommandImpl implements GetMaterialObjectCmd {
    private static final String CLASSNAME = GetMaterialObjectCmdImpl.class.getName();
    private static final Logger LOGGER = Logger.getLogger(CLASSNAME);

    private MaterialService materialService;
    private JSONObject materialsJson;


    @Override
    public void performExecute() {
        final String methodName = "performExecute";
        LOGGER.entering(CLASSNAME, methodName);

        List<MaterialBean> materials = materialService.getAllMaterials();
        materialsJson = materialsToJsonObject(materials);

        LOGGER.exiting(CLASSNAME, methodName);
    }

    @Override
    public void setResponseProperties() {
        attributes.addAttribute("materials", materialsJson.toJSONString());
        super.setResponseProperties();
    }

    private JSONObject materialsToJsonObject(List<MaterialBean> materials) {
        JSONObject json = new JSONObject();
        Map<String, List<MaterialBean>> map = new HashMap<>();
        materials.stream()
                .map(MaterialBean::getMaterialType)
                .map(MaterialTypeBean::getName)
                .distinct()
                .forEach(x -> findMaterialByType(x, materials, map));
        json.putAll(map);
        return json;
    }

    private void findMaterialByType(String type, List<MaterialBean> materials, Map<String, List<MaterialBean>> map) {
        List<MaterialBean> fitMaterials = materials.stream()
                .filter(x -> Objects.equals(x.getMaterialType().getName(), type))
                .collect(Collectors.toList());
        map.put(type, fitMaterials);
    }

    @Autowired
    public void setMaterialService(MaterialServiceImpl materialService) {
        this.materialService = materialService;
    }
}

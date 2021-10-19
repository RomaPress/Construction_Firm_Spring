package com.roman.pres.constructionfirm.controller.commands;

import com.roman.pres.constructionfirm.bean.persistence.MaterialBean;
import com.roman.pres.constructionfirm.bean.persistence.MaterialTypeBean;
import com.roman.pres.constructionfirm.command.ControllerCommandImpl;
import com.roman.pres.constructionfirm.services.MaterialService;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class GetMaterialObjectCmdImpl extends ControllerCommandImpl implements GetMaterialObjectCmd {
    private static final String CLASSNAME = GetMaterialObjectCmdImpl.class.getName();
    private static final Logger LOGGER = Logger.getLogger(CLASSNAME);

    private MaterialService materialService;
    private String materialsJson;


    @Override
    public void performExecute() {
        final String methodName = "performExecute";
        LOGGER.entering(CLASSNAME, methodName);

        List<MaterialBean> materials = materialService.getAllMaterials();
        JSONObject jsonObject = materialsToJsonObject(materials);
        materialsJson = jsonObject.toJSONString();

        LOGGER.exiting(CLASSNAME, methodName);
    }

    @Override
    public void setResponseProperties() {
        attributes.put("materials", materialsJson);
    }

    private JSONObject materialsToJsonObject(List<MaterialBean> materials) {
        Map<String, List<JSONObject>> map = new HashMap<>();
        List<String> types = getAvailableTypes(materials);
        types.forEach(x -> map.put(x, findMaterialsByType(x, materials)));
        return new JSONObject(map);
    }

    private List<JSONObject> findMaterialsByType(String type, List<MaterialBean> materials) {
        return materials.stream()
                .filter(material -> Objects.equals(material.getMaterialType().getName(), type))
                .map(material -> {
                    JSONObject json = new JSONObject();
                    json.put("price", material.getPrice());
                    json.put("name", material.getName());
                    json.put("id", material.getId());
                    return json;
                })
                .collect(Collectors.toList());
    }

    private List<String> getAvailableTypes(List<MaterialBean> materials) {
        return materials.stream()
                .map(MaterialBean::getMaterialType)
                .map(MaterialTypeBean::getName)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public void setMaterialService(MaterialService materialService) {
        this.materialService = materialService;
    }
}

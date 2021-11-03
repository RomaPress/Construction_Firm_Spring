package com.roman.pres.constructionfirm.controller.handlers;

import com.roman.pres.constructionfirm.command.factory.CommandFactory;
import com.roman.pres.constructionfirm.controller.commands.GetMaterialObjectCmd;
import com.roman.pres.constructionfirm.services.MaterialService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/material")
public class MaterialHandler {

    private final MaterialService materialService;

    @Autowired
    public MaterialHandler(MaterialService materialService) {
        this.materialService = materialService;
    }

    @SneakyThrows
    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public String showMaterials(Model model) {
        GetMaterialObjectCmd cmd = (GetMaterialObjectCmd) CommandFactory.createInstance(GetMaterialObjectCmd.NAME);
        cmd.setMaterialService(materialService);
        cmd.execute();
        model.addAllAttributes(cmd.getAttributes());
        return "MaterialListPage";
    }
}

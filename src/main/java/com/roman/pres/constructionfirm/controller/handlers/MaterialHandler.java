package com.roman.pres.constructionfirm.controller.handlers;

import com.roman.pres.constructionfirm.command.factory.CommandFactory;
import com.roman.pres.constructionfirm.controller.commands.GetMaterialObjectCmd;
import com.roman.pres.constructionfirm.exeption.ControllerCommandException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/materials")
public class MaterialHandler {

    @GetMapping()
    public void showMaterials(HttpSession session, Model model){
        try {
            GetMaterialObjectCmd cmd = (GetMaterialObjectCmd) CommandFactory.createInstance(GetMaterialObjectCmd.NAME);
            cmd.setModel(model);
            cmd.execute();
        } catch (ControllerCommandException e) {
            e.printStackTrace();
        }
    }
}

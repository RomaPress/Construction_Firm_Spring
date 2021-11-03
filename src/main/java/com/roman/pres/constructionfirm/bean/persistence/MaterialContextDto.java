package com.roman.pres.constructionfirm.bean.persistence;

import net.minidev.json.JSONObject;

import java.util.List;
import java.util.Map;


public class MaterialContextDto {
    private Map<String, List<JSONObject>> map;

    public MaterialContextDto() {
    }

    public MaterialContextDto(Map<String, List<JSONObject>> map) {
        this.map = map;
    }

    public Map<String, List<JSONObject>> getMap() {
        return map;
    }

    public void setMap(Map<String, List<JSONObject>> map) {
        this.map = map;
    }
}

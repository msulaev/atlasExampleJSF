package com.pdffiller.utils;

import java.util.HashMap;
import java.util.Map;

public class ToolbarColor {

    public static Map<String, String> colorMap = new HashMap<>();
    static  {
        colorMap.put("Red", "rgb(255, 0, 0)");
        colorMap.put("Blue", "rgb(0, 0, 255)");
        colorMap.put("Black", "rgb(0, 0, 0)");
        colorMap.put("White", "rgb(255, 255, 255)");
    }

    public String getCode(String color){
        return colorMap.get(color);
    }

    public String getValueByCode(String rgbCode){
        for(String e: colorMap.keySet()){
            if (colorMap.get(e).equals(rgbCode)){
                return e;
            }
        }
        return "Error: Color not found";
    }

}

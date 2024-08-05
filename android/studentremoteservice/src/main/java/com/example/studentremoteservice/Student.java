package com.example.studentremoteservice;

import java.util.HashMap;
import java.util.Map;

public class Student {

    private static Map<String,String> studentInfos = new HashMap<>();

    public Student(){
        studentInfos.put("1","张三");
        studentInfos.put("2","李四");
        studentInfos.put("3","王五");
    }

    static String queryNamebyId(String id) {
        if (id == null || id.isEmpty()) {
            return "查询的key不对";
        }
        return studentInfos.get(id);
    }
}

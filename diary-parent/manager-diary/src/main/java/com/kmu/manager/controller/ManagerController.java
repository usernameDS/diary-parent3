package com.kmu.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagerController {
    //便于页面查看，假的
    @RequestMapping("/{path}.html")
    public String page(@PathVariable("path") String path){
        return path;
    }
}

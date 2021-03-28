package com.practice.springmvc.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Luo Bao Ding
 * @since 2018/10/26
 */
@RestController
@RequestMapping("/cascade")
public class CascadeController {

    @RequestMapping
    public String cascade(){
        return "success";
    }
}

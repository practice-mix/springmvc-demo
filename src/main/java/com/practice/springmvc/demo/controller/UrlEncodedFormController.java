package com.practice.springmvc.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Luo Bao Ding
 * @since 2019/5/31
 */
@RestController
public class UrlEncodedFormController {

    /**
     * application/x-www-form-urlencoded, <br>
     * spring-boot-maven-plugin 保留了param name, 使得未加@RequestParam也能行,<br>
     * 但建议使用@RequestParam
     */
    @RequestMapping(path = "/msgRead", method = RequestMethod.POST)
    public Object msgRead(Long fid, Integer msgTime, Long uid, String sign) {
        System.out.println("fid = [" + fid + "], msgTime = [" + msgTime + "], uid = [" + uid + "], sign = [" + sign + "]");

        return "successful";
    }

    @RequestMapping(path = "/mix", method = RequestMethod.POST)
    public Object mix(@RequestParam("username") String username, @RequestParam("age") Integer age, Integer height, Integer score) {
        System.out.println("username = [" + username + "], age = [" + age + "], height = [" + height + "], score = [" + score + "]");
        return "successful";
    }


}

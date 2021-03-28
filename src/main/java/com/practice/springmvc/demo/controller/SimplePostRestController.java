package com.practice.springmvc.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.practice.springmvc.demo.model.Auth;
import com.practice.springmvc.demo.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SimplePostRestController {

    /**
     * thread-safe
     */
    private final ObjectWriter writer;

    {
        ObjectMapper objectMapper = new ObjectMapper();
        writer = objectMapper.writer();
    }

    @PostMapping("/urlencoded")
    public Object urlencoded(String sign, String uid) {
        String echo = "sign = [" + sign + "], uid = [" + uid + "]";
        System.out.println(echo);
        return echo;
    }

    @RequestMapping("/multipart")
    public Auth multipart(String sign, String uid) {
        String echo = "sign = [" + sign + "], uid = [" + uid + "]";
        System.out.println(echo);
        return new Auth(sign, uid);
    }

    @RequestMapping("/multipart2")
    public Auth multipart(HttpServletRequest request) {
        String sign = request.getParameter("sign");
        String uid = request.getParameter("uid");
        String echo = "sign = [" + sign + "], uid = ["
                + uid + "]";
        System.out.println(echo);

        return new Auth(sign, uid);
    }

    /**
     * POST请求也可在url中传参数, 且能被mvc解析到形参, 且能通过request.getParameter来取出
     */
    @PostMapping("/json")
    public Map<String, Object> json(String sign, String uid, @RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>(8);
        ServletInputStream inputStream = null;
        try {
            inputStream = request.getInputStream();
            map.put("request.inputStream", inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            map.put("request.inputStreamStr.error", e.getMessage());

        }
        String signFromReq = request.getParameter("sign");
        String uidFromReq = request.getParameter("uid");
        map.put("signFromReq", signFromReq);
        map.put("uidFromReq", uidFromReq);

        map.put("sign", sign);
        map.put("uid", uid);

        map.put("user", user);

        return map;
    }

    @PostMapping("/json2")
    public Auth json2(HttpServletRequest request, HttpServletResponse response) {
        Auth auth = new Auth();
        String sign = request.getParameter("sign");//null
        String uid = request.getParameter("uid");//null
        auth.setSign(sign);
        auth.setUid(uid);

        return auth;

    }

    @PostMapping(path = "/produces", produces = {"application/javascript", "application/json"})
    public String produces(String sign, String uid) throws JsonProcessingException {
        Auth auth = new Auth();
        auth.setSign(sign);
        auth.setUid(uid);
        return writer.writeValueAsString(auth);
    }
}

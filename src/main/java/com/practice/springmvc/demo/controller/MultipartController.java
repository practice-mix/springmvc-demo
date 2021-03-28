package com.practice.springmvc.demo.controller;

import com.practice.springmvc.demo.model.MyForm;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author Luo Bao Ding
 * @since 2018/12/12
 */
@Controller
public class MultipartController {

    @ResponseBody
    @PostMapping("/form")
    public String handleFormUpload(@RequestParam("name") String name,
                                   @RequestParam("file") MultipartFile file) throws IOException {

        Assert.isTrue(!file.isEmpty(), "the file should not be empty");
        byte[] bytes = file.getBytes();
        return "file = " + new String(bytes, StandardCharsets.UTF_8);
    }

    @PostMapping("/form2")
    public String handleFormUpload2(@RequestParam("name") String name,
                                    @RequestParam("file") MultipartFile file) throws IOException {

        Assert.isTrue(!file.isEmpty(), "the file should not be empty");
        byte[] bytes = file.getBytes();
        System.out.println("file = " + new String(bytes, StandardCharsets.UTF_8));

        return "redirect:http://httpbin.org/post";//todo why not effective
    }

    @ResponseBody
    @PostMapping("/form3")
    public String handleFormUpload3(MyForm form, BindingResult errors) throws IOException {
        MultipartFile file = form.getFile();
        Assert.isTrue(!file.isEmpty(), "the MyForm.file should not be empty");
        byte[] bytes = file.getBytes();
        System.out.println("MyForm.file = " + new String(bytes, StandardCharsets.UTF_8));

        return "MyForm.file = " + new String(bytes, StandardCharsets.UTF_8);
    }


}

package com.practice.springmvc.demo.model;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Luo Bao Ding
 * @since 2018/12/12
 */
public class MyForm {

    private String name;

    private MultipartFile file;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}

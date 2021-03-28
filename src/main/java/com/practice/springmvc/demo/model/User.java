package com.practice.springmvc.demo.model;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * @author Luo Bao Ding
 * @since 2018/10/16
 */
public class User implements Serializable {
    private static final long serialVersionUID = 642255272957341411L;

    private String username;
    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("username='" + username + "'")
                .add("age=" + age)
                .toString();
    }
}

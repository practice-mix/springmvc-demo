package com.practice.springmvc.demo.model;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * @author Luo Bao Ding
 * @since 2018/10/16
 */
public class Auth implements Serializable {

    private static final long serialVersionUID = -98919357002282251L;

    private String sign;
    private String uid;

    public Auth() {
    }

    public Auth(String sign, String uid) {
        this.sign = sign;
        this.uid = uid;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Auth.class.getSimpleName() + "[", "]")
                .add("sign='" + sign + "'")
                .add("uid='" + uid + "'")
                .toString();
    }
}

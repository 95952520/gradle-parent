package com.xuchen.gradle.api.demo;


import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;

/**
 * @author xuchen
 * @date 2019/08/06
 */
public class Demo {
    public static void main(String[] args) {
        HttpResponse response = HttpUtil.createGet("http://localhost/user/get")
                .form("id", "5")
                .execute();
        System.out.println(response.body());
    }
}

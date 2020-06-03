package com.xuchen.gradle.api.demo;


import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;

/**
 * @author xuchen
 * @date 2019/08/06
 */
public class Demo {
    public static void main(String[] args) {
//        HttpResponse response = HttpUtil.createPost("http://localhost/user/post")
//                .body(JSONUtil.toJsonStr(new HashMap<String, String>() {{
//                    put("id", "5");
//                    put("createTime", "2020-04-09 09:58:34");
//                }}))
//                .execute();
        HttpResponse response = HttpUtil.createGet("http://localhost/login")
                .form("nickName", "nickName5")
                .form("password", "000")
                .execute();
//        HttpResponse response = HttpUtil.createGet("http://localhost/hello")
//                .form("name", "namename")
//                .execute();
        System.out.println(response.body());
    }
}

package com.xuchen.gradle.api.demo;


import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;

import java.util.HashMap;

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
//        HttpResponse response = HttpUtil.createGet("http://localhost/user/get")
//                .form("id", "5")
////                .form("createTime", "2020-04-09T09:58:34")
//                .execute();
        HttpResponse response = HttpUtil.createGet("http://localhost/rocket/sync")
                .form("msg", "myMsg")
                .execute();
        System.out.println(response.body());
    }
}

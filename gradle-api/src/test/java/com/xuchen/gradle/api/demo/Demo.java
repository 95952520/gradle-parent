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
        HttpResponse response = HttpUtil.createGet("http://localhost/hello")
                .header("Authorization", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJncmFkbGVTdWJqZWN0IiwiY3VzdG9tZXJfdXNlciI6IntcImNyZWF0ZVRpbWVcIjoxNTkxMDg2MTI3OTk3LFwibmlja05hbWVcIjpcIm5pY2tOYW1lOTlcIixcImlkXCI6OTl9IiwiaXNzIjoiZ3JhZGxlU2VydmVyIiwiZXhwIjoxNTkxMDkzMzI4LCJpYXQiOjE1OTEwODYxMjh9.3X73XUB5Ng4cHfd6g2ebRgY9AW6ULjEnuIaMmBhkxFg")
                .form("name", "xuchen")
                .execute();
        System.out.println(response.body());
    }
}

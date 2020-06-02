package com.xuchen.gradle.api.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.xuchen.gradle.core.core.common.RequestContextProxy;
import com.xuchen.gradle.core.model.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Edwin
 * @date 2020/6/2
 */
@Slf4j
@RestController
public class HelloController {

    @GetMapping("hello")
    public R hello(String name){
        log.info(JSONUtil.toJsonStr(RequestContextProxy.getRequestContextBean()));
        return R.success(StrUtil.format("hello {}!",name));
    }
}

package com.xuchen.gradle.api.controller;


import cn.hutool.core.img.ImgUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.xuchen.gradle.core.entity.User;
import com.xuchen.gradle.core.model.R;
import com.xuchen.gradle.core.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * <p>
 * 前端控制器</p>
 *
 * @author xuchen
 * @since 2019-08-07
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("get")
    public R get(User user) {
        user = userService.getById(user);
        log.info(user.toString());
        return R.success(user);
    }

    @GetMapping("download")
    public void download() throws IOException {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        QrConfig qrConfig = new QrConfig(300, 300);
        qrConfig.setImg(ImgUtil.read(new URL("http://img.zhenyang.work/logo.jpg")));
        response.setHeader("content-Type", "application/x-png");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("二维码.png", StandardCharsets.UTF_8.name()));
        QrCodeUtil.generate("http://127.0.0.1/text.html?id=" + 1, qrConfig, ImgUtil.IMAGE_TYPE_PNG, response.getOutputStream());
    }


}

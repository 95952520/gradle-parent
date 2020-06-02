package com.xuchen.gradle.api.controller;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.InputStream;

/**
 * <p>
 * 上传下载文件demo</p>
 *
 * @author xuchen
 * @since 2019-08-07
 */
@Slf4j
@RestController
@RequestMapping("/file")
public class FileController {

    @PostMapping("/uploadAndDownload")
    public void upload(@RequestParam("file") MultipartFile file) {
        InputStream inputStream = null;
        BufferedOutputStream outputStream = null;
        try {
            // 获取文件名
            String fileName = file.getOriginalFilename();
            log.info("上传的文件名为：" + fileName);
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            log.info("文件的后缀名为：" + suffixName);
            // 设置文件存储路径
            inputStream = file.getInputStream();
            File saveFile = FileUtil.file("F:/uploadFile.txt");
            outputStream = FileUtil.getOutputStream(saveFile);
            IoUtil.copy(inputStream, outputStream);
            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletResponse response = servletRequestAttributes.getResponse();
            ServletOutputStream servletOutputStream = response.getOutputStream();
            response.setContentType("application/force-download");
            response.addHeader("Content-Disposition", "attachment;fileName=testTxt.txt");
            inputStream = FileUtil.getInputStream(saveFile);
            IoUtil.copy(inputStream, servletOutputStream);
        } catch (Exception e) {
            log.error("上传下载异常", e);
        } finally {
            IoUtil.close(inputStream);
            IoUtil.close(outputStream);
        }
    }
}

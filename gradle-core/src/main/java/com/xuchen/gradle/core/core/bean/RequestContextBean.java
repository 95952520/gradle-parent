package com.xuchen.gradle.core.core.bean;


import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.useragent.UserAgentUtil;
import com.alibaba.fastjson.JSON;
import com.xuchen.gradle.core.mysql.user.entity.User;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Edwin
 * @date 2020/6/2
 */
@Data
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestContextBean {
    private User user;


    private String clientIp;
    private Map<String, String> header;
    private String url;
    private String browser;
    private String hostIp;
    private String requestMethod;
    private String requestArgs;

    public RequestContextBean(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String userAgent = request.getHeader("User-Agent");
        String hostIp = null;
        try {
            hostIp = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {

        }
        setClientIp(ServletUtil.getClientIP(request));
        setBrowser(UserAgentUtil.parse(userAgent).getBrowser().toString());
        setHeader(getHeaderMap(request));
        setUrl(request.getRequestURI());
        setRequestArgs(getJsonParams(request.getParameterMap()));
        setHostIp(hostIp);
        setRequestMethod(StrUtil.isBlank(request.getMethod()) ? "未知请求" : request.getMethod());
    }

    private static Map<String, String> getHeaderMap(HttpServletRequest request) {
        Enumeration<String> names = request.getHeaderNames();
        Map<String, String> headerMap = new HashMap<>();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            headerMap.put(name, request.getHeader(name));
        }
        return headerMap;
    }

    private static String getJsonParams(Map<String, String[]> map) {
        Map<String, String> paramsMap = new HashMap<>();
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            paramsMap.put(entry.getKey(), entry.getValue()[0]);
        }
        return JSON.toJSONString(paramsMap);
    }
}

package com.xuchen.gradle.core.core.common;

import cn.hutool.extra.spring.SpringUtil;
import com.xuchen.gradle.core.core.bean.RequestContextBean;
import com.xuchen.gradle.core.mysql.user.entity.User;

/**
 * @author Edwin
 * @date 2020/6/2
 */
public class RequestContextProxy {

    public static RequestContextBean getRequestContextBean(){
        return SpringUtil.getBean(RequestContextBean.class);
    }

    public static User getUser(){
        return getRequestContextBean().getUser();
    }
}

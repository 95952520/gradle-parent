package com.xuchen.gradle.core.mysql.user.service.impl;

import com.xuchen.gradle.core.mysql.user.dao.UserDao;
import com.xuchen.gradle.core.mysql.user.service.UserService;
import com.xuchen.gradle.core.mysql.user.entity.User;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuchen
 * @since 2019-08-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}

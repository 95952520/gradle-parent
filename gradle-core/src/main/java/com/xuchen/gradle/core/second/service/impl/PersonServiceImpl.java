package com.xuchen.gradle.core.second.service.impl;

import com.xuchen.gradle.core.second.entity.Person;
import com.xuchen.gradle.core.second.dao.PersonDao;
import com.xuchen.gradle.core.second.service.PersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuchen
 * @since 2019-09-05
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonDao, Person> implements PersonService {

}

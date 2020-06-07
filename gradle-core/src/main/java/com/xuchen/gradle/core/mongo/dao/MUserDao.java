//package com.xuchen.gradle.core.mongo.dao;
//
//import com.xuchen.gradle.core.mongo.entity.MUser;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.mongodb.repository.MongoRepository;
//
//import java.util.List;
//
//public interface MUserDao extends MongoRepository<MUser,Integer> {
//
//    List<MUser> findMUserBySex(Integer sex);
//
//    List<MUser> findMUserBySex(Integer sex, Pageable pageable);
//
//    List<MUser> findByAgeBetween(Integer begin,Integer end);
//
//}

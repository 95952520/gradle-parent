package com.xuchen.gradle.api.generate;

import cn.hutool.core.io.FileUtil;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;


/**
 * 生成相关代码
 */
public class MybatisPlusGenerate {
    /**
     * 数据库表名
     */
    private static String[] tableNames = {"user"};
    /**
     * 作者
     */
    private static String author = "xuchen";
    private static String dbUrl = "jdbc:mysql://localhost:3306/just_test?useSSL=false";
    private static String dbName = "root";
    private static String dbPassword = "root";
    private static String driverName = "com.mysql.jdbc.Driver";

    private static String projectPath = System.getProperty("user.dir");
    private static String serviceName = "gradle-core";
    private static String servicePath = projectPath + "\\" + serviceName;
    private static String serviceSrcPath = servicePath + "\\src\\main\\java";
    private static String serviceResourcePath = servicePath + "\\src\\main\\resources";
    /**
     * 包名称
     */
    private static String servicePackageName = "com.xuchen.gradle.core";

    public static void main(String[] args) {
        generateByTables();
        moveFile();
        delController();
    }

    private static void generateByTables() {
        GlobalConfig config = new GlobalConfig()
                .setActiveRecord(false)
                .setAuthor(author)
                .setOutputDir(serviceSrcPath)
                .setFileOverride(true)
                .setEnableCache(false)
                .setOpen(false)
                .setDateType(DateType.ONLY_DATE)
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setEntityName("%s")
                .setMapperName("%sDao")
                .setXmlName("%sMapper");
        DataSourceConfig dataSourceConfig = new DataSourceConfig()
                .setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername(dbName)
                .setPassword(dbPassword)
                .setDriverName(driverName);
        StrategyConfig strategyConfig = new StrategyConfig()
                .setCapitalMode(true)
                .setEntityLombokModel(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        new AutoGenerator()
                .setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(servicePackageName)
                                .setMapper("dao")
                                .setXml("mapper")
//                                .setController("controller")
                                .setEntity("entity"))
                .setTemplateEngine(new FreemarkerTemplateEngine())
                .setCfg(new InjectionConfig() {
                    @Override
                    public void initMap() {

                    }
                })
                .execute();
    }

    /**
     * 将xml文件移动到mapper中
     */
    private static void moveFile() {
        FileUtil.move(new File(serviceSrcPath + "\\" + servicePackageName.replace(".", "\\") + "\\mapper")
                , new File(serviceResourcePath)
                , true);
    }

    /**
     * 删除生成controller目录
     */
    private static void delController() {
        FileUtil.del(serviceSrcPath+"\\" + servicePackageName.replace(".", "\\") + "\\controller");
    }
}

package com.kmu;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

public class GenertorTest {
    @Test
    public void testGenerator() {
        // 1. 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("E:\\idea_workspaces2\\diary-parent\\diary-parent\\mybatis-generator\\src\\main\\java");// 指定生成代码输出的路径
        gc.setFileOverride(true);// 设置是否覆盖已有文件
        gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML中是否生成 ResultMap
        gc.setBaseColumnList(false);// XML columList
//        gc.setAuthor("博哥");
        // 自定义三层架构中的文件命名，注意 %s 会自动填充表实体属性！
        // 如：%sDao => EmployeeDao
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");

        // 2. 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/db_diary?characterEncoding=utf8");
        // 3. 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 此处可以修改为您的表前缀
        strategy.setTablePrefix("t_");//设置表前缀，将来生成的文件自动去掉前缀
        strategy.setFieldPrefix(new String[]{"m_"});//设置字段前缀，将来生成的属性名自动去掉前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);//开启下划线转驼峰命名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//开启下划线转驼峰命名
        // 4. 包名策略配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.kmu");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setXml("mapper");

        // 5. 整合配置
        AutoGenerator mpg = new AutoGenerator();
//    mpg.setCfg(cfg);
        mpg.setGlobalConfig(gc);
        mpg.setDataSource(dsc);
        mpg.setStrategy(strategy);
        mpg.setPackageInfo(pc);
        // 6. 执行
        mpg.execute();
    }
}

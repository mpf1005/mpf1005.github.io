package com.offenhealth.hdmp.eshop.business.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * 事务配置
 * Created by earl on 2017/3/26.
 */
@Configuration
@MapperScan(basePackages = "com.offenhealth.hdmp.eshop.business.dao")     //dao包
@EnableTransactionManagement     //开启事务支持
public class TransactionConfig implements TransactionManagementConfigurer  {

    //初始化数据源
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        //事务默认选择的数据源
        return new DataSourceTransactionManager(dataSource());
    }


}
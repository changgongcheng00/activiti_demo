package com.test.activiti.configuration;

/**
 * @ClassName ActivitiConfig
 * @Description TODO
 * @Author cheng
 * @Date 2020/6/16 23:00
 **/
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class ActivitiConfig {

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    /**
     * Description 初始化配置，将创建28张表
     * processEngineConfiguration
     * @Author zhangcheng
     */
    @Bean
    public StandaloneProcessEngineConfiguration processEngineConfiguration(){
        StandaloneProcessEngineConfiguration configuration = new StandaloneProcessEngineConfiguration();
        configuration.setDataSource(dataSource);
        configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        configuration.setAsyncExecutorActivate(false);
        return configuration;
    }

    /**
     * Description 创建引擎
     * processEngine
     * @Author zhangcheng
     */
    @Bean
    public ProcessEngine processEngine(){
        return processEngineConfiguration().buildProcessEngine();
    }
}

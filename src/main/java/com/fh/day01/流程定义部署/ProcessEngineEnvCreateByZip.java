package com.fh.day01.流程定义部署;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

import java.io.InputStream;
import java.util.zip.ZipInputStream;

/**
 * 通过zip的方式实现流程的部署
 */
public class ProcessEngineEnvCreateByZip {

    public static void main(String[] args) {
        // 1.创建配置类
        ProcessEngineConfiguration configuration =
                ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("/config/activiti_cfg.xml");
        // 2.创建流程实例
        ProcessEngine processEngine = configuration.buildProcessEngine();
        // 3.获取资源管理service
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 4.部署流程
        InputStream inputStream = ProcessEngineEnvCreateByZip.class.getResourceAsStream("/disgram/day01/holiday.zip");
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        Deployment deploy = repositoryService.createDeployment()
                .addZipInputStream(zipInputStream)
                .name("请假申请流程")
                .deploy();
    }
}

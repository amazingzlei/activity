package com.fh.day01.流程定义部署;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

// 3.流程定义部署
public class ProcessDeployMent {

    public static void main(String[] args) {
        // 1.获取工作流引擎配置类
        ProcessEngineConfiguration processEngineConfiguration =
                ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("/config/activiti_cfg.xml");
        // 2.获取工作流引擎对象
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        // 3.获取工作流资源管理service
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 4.部署流程
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("disgram/day01/holiday.bpmn") // 添加bpmn资源文件
                .addClasspathResource("disgram/day01/holiday.png") // 添加图片资源文件
                .name("请假申请流程")
                .deploy();// 部署流程
        System.out.println(deployment);
    }
}

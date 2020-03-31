package com.fh.day01.流程定义删除;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;

public class ProcessDelete {
    public static void main(String[] args) {
        // 1.获取工作流引擎配置类
        ProcessEngineConfiguration processEngineConfiguration =
                ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("/config/activiti_cfg.xml");
        // 2.获取工作流引擎对象
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        // 3.获取资源service
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 4.删除流程定义，注意如果有正在执行的流程则不能删除，如果将级联删除参数设置为true
        repositoryService.deleteDeployment("1",true);
    }
}

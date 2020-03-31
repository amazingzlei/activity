package com.fh.day01.流程定义查询;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import java.util.List;

public class ProcessQuery {
    public static void main(String[] args) {
        // 1.获取工作流引擎配置类
        ProcessEngineConfiguration processEngineConfiguration =
                ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("/config/activiti_cfg.xml");
        // 2.获取工作流引擎对象
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        // 3.获取资源service
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 4.获取流程定义查询类
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();

        List<ProcessDefinition> definitions = processDefinitionQuery.list();

        for (ProcessDefinition processDefinition:definitions) {
            System.out.println(processDefinition.getId());
            System.out.println(processDefinition.getKey());
            System.out.println(processDefinition.getName());
            System.out.println(processDefinition.getResourceName());
            System.out.println(processDefinition.getDeploymentId());
        }
    }
}

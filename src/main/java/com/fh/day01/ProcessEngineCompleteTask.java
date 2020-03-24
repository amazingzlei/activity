package com.fh.day01;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.TaskService;

/**
 * 处理任务
 */
public class ProcessEngineCompleteTask {

    public static void main(String[] args) {
        // 1.获取工作流引擎配置类
        ProcessEngineConfiguration processEngineConfiguration =
                ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("/config/activiti_cfg.xml");
        // 2.获取工作流引擎对象
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        // 3.获取taskservice
        TaskService taskService = processEngine.getTaskService();
        // 4.处理任务
        taskService.complete("10002");
    }
}

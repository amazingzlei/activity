package com.fh.day01.流程启动;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 4.启动流程，流程实例相当于java中new出来的一个对象
 */
public class ProcessEngineStart {

    public static void main(String[] args) {
        // 获取工作流引擎配置类
        ProcessEngineConfiguration processEngineConfiguration =
                ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("/config/activiti_cfg.xml");
        // 获取工作流引擎类
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        // 获取运行service
        RuntimeService runtimeService = processEngine.getRuntimeService();
        // 启动流程实列
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday_process");

        System.out.println(processInstance.getName());
        System.out.println(processInstance.getId());
    }
}

package com.fh.day01.activiti部署;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

/**
 *  1.部署activity 即创建activity所依赖的表
 */
public class ProcessEngineEnvCreate {

    public static void main(String[] args) {
        // 1.创建ProcessEngineConguration对象
        ProcessEngineConfiguration processEngineConfiguration =
                ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("/config/activiti_cfg.xml");
        // 2.创建ProcessEngine对象
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        System.out.println(processEngine);
    }
}

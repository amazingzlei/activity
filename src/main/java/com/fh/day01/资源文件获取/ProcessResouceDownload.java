package com.fh.day01.资源文件获取;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class ProcessResouceDownload {

    public static void main(String[] args) throws IOException {
        // 1.获取工作流引擎配置类
        ProcessEngineConfiguration processEngineConfiguration =
                ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("/config/activiti_cfg.xml");
        // 2.获取工作流引擎对象
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        // 3.获取仓库service
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 4.获取流程定义查询
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        // 设置查询条件
        processDefinitionQuery.processDefinitionKey("holiday_process");
        // 5.执行查询
        ProcessDefinition processDefinition = processDefinitionQuery.singleResult();

        // 6.获取资源 第一个参数为部署id 第二个参数为资源名
        InputStream bpmnin =
                repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), processDefinition.getResourceName());

        InputStream imgin =
                repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), processDefinition.getDiagramResourceName());

        // 7.转换

        FileOutputStream bpmnout = new FileOutputStream("E:\\"+processDefinition.getResourceName());
        FileOutputStream imgout = new FileOutputStream("E:\\"+processDefinition.getDiagramResourceName());

        IOUtils.copy(bpmnin, bpmnout);
        IOUtils.copy(imgin, imgout);
    }
}

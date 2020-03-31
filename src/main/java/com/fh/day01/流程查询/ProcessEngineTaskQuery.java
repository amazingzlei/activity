package com.fh.day01.流程查询;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;

import java.util.List;

/**
 * 5.任务查询，查询当前某个用户有哪些流程需要处理
 */
public class ProcessEngineTaskQuery {

    public static void main(String[] args) {
        // 1.获取工作流引擎配置类
        ProcessEngineConfiguration processEngineConfiguration =
                ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("/config/activiti_cfg.xml");
        // 2.获取工作流引擎对象
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        // 3.获取任务service
        TaskService taskService = processEngine.getTaskService();
        // 4.创建查询
        List<Task> taskList = taskService.createTaskQuery()
                .processDefinitionKey("holiday_process") // 查询哪一个流程
                .taskAssignee("曾磊") // 任务负责人，即该负责人有哪些任务需要执行
                .list();

        for (Task task: taskList
             ) {
            System.out.println(task.getAssignee());// 获取任务负责人
            System.out.println(task.getId());
            System.out.println(task.getName());
        }
    }
}

package com.example.cloud.consumer.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.example.cloud.consumer.service.ExamineService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExamineServiceImpl implements ExamineService {

	@Autowired
    private RuntimeService runtimeService;
	@Autowired
    private TaskService taskService;
    
    private static final String PROCESS_DEFINE_KEY = "examine";
	
	@Override
	public Object submitApproveData(Object obj) {
		ProcessInstance processInstance;
		Map<String, Object> map = new HashMap<>();
        // 开始流程
        processInstance = runtimeService.startProcessInstanceByKey(PROCESS_DEFINE_KEY, map);
        // 查询当前任务
        Task currentTask = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
		return currentTask;
	}

    @Override
    public Object add(Object object) {
        return null;
    }

}

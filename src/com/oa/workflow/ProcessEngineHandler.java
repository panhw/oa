package com.oa.workflow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.oa.common.AppContextHolder;

@Component
public class ProcessEngineHandler {
	private static Logger logger=LoggerFactory.getLogger(ProcessEngineHandler.class);
	@Resource
	ProcessEngine processEngine;
	
	public void test(){
		//=(ProcessEngine) AppContext.getContext().getBean("processEngine");
		if (null==processEngine) System.out.println("----------------engine is null------------------");
		RepositoryService rpSv=processEngine.getRepositoryService();
		if (null==rpSv) System.out.println("--------------------rpSv is null--------------------");
		
		
		//deploy
		rpSv.createDeployment().addClasspathResource("vacationRequest.bpmn20.xml").deploy();
		      System.out.println("Number of process definitions: " + rpSv.createProcessDefinitionQuery().count());
		logger.info("Number of process definitions: " + rpSv.createProcessDefinitionQuery().count());
		
		
		//start
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("employeeName", "Kermit");
		variables.put("numberOfDays", new Integer(4));
		variables.put("vacationMotivation", "I'm really tired!");
		      
		RuntimeService runtimeService = processEngine.getRuntimeService();
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("vacationRequest", variables);
		      
		// Verify that we started a new process instance
		logger.info("Number of process instances: " + runtimeService.createProcessInstanceQuery().count());
		
		
		//query
		TaskService taskService = processEngine.getTaskService();
		List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("management").list();
		for (Task task : tasks) {
		  logger.info("Task available: " + task.getName());
		} 
		
		//complete
		Task task = tasks.get(0);
	      
		Map<String, Object> taskVariables = new HashMap<String, Object>();
		taskVariables.put("vacationApproved", "false");
		taskVariables.put("managerMotivation", "We have a tight deadline!");
		taskService.complete(task.getId(), taskVariables);
	}
}

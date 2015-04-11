package com.takahitonara.ttodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/api/tasks")
public class ApiController {

	@Autowired
	TaskRepository repository;
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	void updateTask(@PathVariable("id") Integer id,
			@RequestParam("status") Integer status) {

		// PKを指定して更新するRecordを指定する。
		TaskEntity task = repository.getOne(id);
		task.setStatus(status);
		repository.save(task);
	}
}

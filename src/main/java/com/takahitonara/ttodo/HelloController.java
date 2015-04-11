package com.takahitonara.ttodo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@Autowired
	TaskRepository repository;

	// input formを表示
	@RequestMapping("/input")
	public String input() {
		return "home/input"; // input form
	}

	// inputフォームから受け取ってhello.htmlへ
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public String send(Model model, @RequestParam("name") String name) {
		model.addAttribute("name", name);
		return "home/hello"; // View file is templates/hello.html
	}

	@RequestMapping("/tasks")
	public String tasksView(Model model) {
		List<TaskEntity> list = repository.findAll();
		List<Task> results = list
				.stream()
				.map(task -> new Task(task.getId(), task.getTitle(), task
						.getDescription(), task.getStatus(),
						pickUpHoursAndMinutes(task.getStartDateTime()),
						pickUpHoursAndMinutes(task.getEndDateTime())))
				.collect(Collectors.toList());
		model.addAttribute("results", results);
		return "home/tasks";
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String taskSearch(Model model, @RequestParam("title") String title,
			@RequestParam("description") String description) {
		TaskEntity task = new TaskEntity(title, description);
		repository.saveAndFlush(task);
		Iterable<TaskEntity> list = repository.findAll();
		model.addAttribute("results", list);
		return "home/tasks";
	}

	String pickUpHoursAndMinutes(LocalDateTime dt) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:MM");
		return dt == null ? "" : dt.format(dtf);
	}
}

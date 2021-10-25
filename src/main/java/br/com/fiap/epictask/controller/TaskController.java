package br.com.fiap.epictask.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.epictask.exception.TaskNotFoundException;
import br.com.fiap.epictask.model.Task;
import br.com.fiap.epictask.model.User;
import br.com.fiap.epictask.repository.TaskRepository;

@Controller
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskRepository repository;
	
	@Autowired
	private MessageSource message;
	
	@GetMapping
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("tasks");
		List<Task> tasks = repository.findAll();
		modelAndView.addObject("tasks", tasks);
		return modelAndView;

	}
	
	@GetMapping("library")
	public ModelAndView biblioteca() {
		ModelAndView modelAndView = new ModelAndView("library");
		List<Task> list2 = repository.findAll();
		modelAndView.addObject("book", list2);
		return modelAndView;
	}
	
	@GetMapping("book")
	public ModelAndView livro() {
		ModelAndView modelAndView = new ModelAndView("book");
		List<Task> list3 = repository.findAll();
		modelAndView.addObject("book2", list3);
		return modelAndView;
	}

	
	@PostMapping
	public String save(@Valid Task task, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "task-form";
		}
		repository.save(task);
		redirect.addFlashAttribute("message", 
				message.getMessage("newtask.success", null, LocaleContextHolder.getLocale())
			);
		return "redirect:/task";
	}
	
	@RequestMapping("new")
	public String create(Task task) {
		return "task-form";
	}
	
	@RequestMapping("library")
	public String create2(Task task) {
		return "library";
	}
	
	@RequestMapping()
	public String create3(Task task) {
		return "book";
	}
	
	
	@GetMapping("/hold/{id}")
	public String hold(@PathVariable Long id, Authentication auth) {
		Optional<Task> optional = repository.findById(id);
		
		if(optional.isEmpty())
			throw new TaskNotFoundException("Tarefa não existe");
		
		Task task = optional.get();
		
		if(task.getUser() != null)
			throw new NotAllowedException("Essa tarefa já está atribuída");
		
		User user = (User) auth.getPrincipal();
		task.setUser(user);
		repository.save(task);
		return "redirect:/task";
	}
	
	@GetMapping("/release/{id}")
	public String release(@PathVariable Long id, Authentication auth) {
		Optional<Task> optional = repository.findById(id);
		
		if(optional.isEmpty())
			throw new TaskNotFoundException("Tarefa não existe");
		
		Task task = optional.get();
		User user = (User) auth.getPrincipal();
		
		if(!task.getUser().equals(user))
			throw new NotAllowedException("Essa tarefa está atribuída para outra pessoa");
	
		task.setUser(null);
		repository.save(task);
		return "redirect:/task";
	}
}

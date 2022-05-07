package todo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import exception.ExceptionController;

@Controller
@SessionAttributes("name")
public class TodoController {

private Log logger = LogFactory.getLog(ExceptionController.class);

@Autowired
TodoService service;

@InitBinder
protected void initBinder(WebDataBinder binder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
}

@ExceptionHandler(value = Exception.class)
public String handleError(HttpServletRequest req, Exception exception) {
	logger.error("Request: " + req.getRequestURL() + " raised " + exception);
	return "common/specific-error";
}

@RequestMapping(value="/list-todos", method=RequestMethod.GET)
public String litsTodo(ModelMap model) {
	model.addAttribute("todos",service.retrieveTodos(getLoggedInUser()));
	return "list-todos";
}


@RequestMapping(value="/add-todo", method=RequestMethod.GET)
public String addTodoForm(ModelMap model) {
//	throw new RuntimeException("Dummy error");
	model.addAttribute("todo",new Todo(0,getLoggedInUser(),"Description here",new Date(),false));
	return "add-todo";
}

@RequestMapping(value="/add-todo", method=RequestMethod.POST)
public String addTodo(ModelMap model,@Valid Todo todo, BindingResult result) {
	if(result.hasErrors()) {
		return "add-todo";
	}
	service.addTodo(getLoggedInUser(), todo.getDesc(), new Date(), false);
	model.clear();
	return "redirect:list-todos";
}

@RequestMapping(value="/delete-todo", method=RequestMethod.GET)
public String deleteTodo(@RequestParam int id,ModelMap model) {
	service.deleteTodo(id);
	model.clear();
	return "redirect:list-todos";
}

@RequestMapping(value="/update-todo", method=RequestMethod.GET)
public String updateTodoForm(@RequestParam int id,ModelMap model) {
	Todo todo=service.retrieveTodo(id);
	model.addAttribute("todo",todo);
	return "add-todo";
}

@RequestMapping(value="/update-todo", method=RequestMethod.POST)
public String updateTodo(@RequestParam int id,ModelMap model,@Valid Todo todo, BindingResult result) {
	System.out.println("helllo");
	if(result.hasErrors()) {
		System.out.println(result.getAllErrors());
		return "add-todo";
	}
	service.updateTodo(todo);
	return "redirect:list-todos";
}

private String getLoggedInUser() {
	Object principal = SecurityContextHolder.getContext()
			.getAuthentication().getPrincipal();

	if (principal instanceof UserDetails)
		return ((UserDetails) principal).getUsername();

	return principal.toString();
}

}

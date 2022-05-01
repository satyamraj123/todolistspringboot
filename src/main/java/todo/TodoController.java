package todo;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {

@Autowired
TodoService service;

@RequestMapping(value="/list-todos", method=RequestMethod.GET)
public String litsTodo(ModelMap model) {
	model.addAttribute("todos",service.retrieveTodos("Satyam Raj"));
	return "list-todos";
}


@RequestMapping(value="/add-todo", method=RequestMethod.GET)
public String addTodoForm(ModelMap model) {
	model.addAttribute("todo",new Todo(0,"Satyam Raj","Description here",new Date(),false));
	return "add-todo";
}

@RequestMapping(value="/add-todo", method=RequestMethod.POST)
public String addTodo(ModelMap model,@Valid Todo todo, BindingResult result) {
	if(result.hasErrors()) {
		return "add-todo";
	}
	service.addTodo("Satyam Raj", todo.getDesc(), new Date(), false);
	model.clear();
	return "redirect:list-todos";
}

@RequestMapping(value="/delete-todo", method=RequestMethod.GET)
public String deleteTodo(@RequestParam int id,ModelMap model) {
	service.deleteTodo(id);
	model.clear();
	return "redirect:list-todos";
}

}

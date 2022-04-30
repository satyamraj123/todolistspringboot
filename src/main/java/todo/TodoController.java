package todo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	
	return "add-todo";
}

@RequestMapping(value="/add-todo", method=RequestMethod.POST)
public String addTodo(@RequestParam String desc,ModelMap model) {
	service.addTodo("Satyam Raj", desc, new Date(), false);
	model.clear();
	return "redirect:list-todos";
}

}

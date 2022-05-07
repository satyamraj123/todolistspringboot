package todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoRestController {
	@Autowired
	TodoService service;
	
	@RequestMapping(path="/todos")
	public List<Todo> retreiveAllTodos(){
		return service.retrieveTodos("Satyam Raj");
	}
	
	@RequestMapping(path="/todos/{id}")
	public Todo retreiveTodo(@PathVariable int id){
		return service.retrieveTodo(id);
	}

}

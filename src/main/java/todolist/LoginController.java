package todolist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
@RequestMapping(value="/login", method=RequestMethod.GET)
public String doGet() {
	//viewresolver
	//in todoservlet.xml, login will be converted to whole address of jsp file by viewresolver
	return "login";
}

@RequestMapping(value="/login", method=RequestMethod.POST)
public String doPost(@RequestParam String name, ModelMap model) {
	model.put("name", name);
	return "welcome";
}
}
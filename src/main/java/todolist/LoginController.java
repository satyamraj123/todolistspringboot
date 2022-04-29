package todolist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
@RequestMapping(value="/login")
public String sayHello() {
	//viewresolver
	//in todoservlet.xml, login will be converted to whole address of jsp file by viewresolver
	return "login";
}
}

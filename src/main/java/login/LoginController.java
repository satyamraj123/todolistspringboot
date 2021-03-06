package login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

//@Autowired
//LoginService service;
//instead of loginservice service=new loginservice() we use autowired and service annotation

@RequestMapping(value="/", method=RequestMethod.GET)
public String doGet(ModelMap model) {
	//viewresolver
	//in todoservlet.xml, login will be converted to whole address of jsp file by viewresolver
	model.put("name", "Satyam Raj");
	return "welcome";
}

//@RequestMapping(value="/login", method=RequestMethod.POST)
//public String doPost(@RequestParam String name, ModelMap model) {
//	model.put("name", name);
//	
//	
//	if(service.isValidUser(name)) {
//		return "welcome";
//	}else {
//		model.put("errorMessage", "invalid user");
//		return "login";
//	}
//}


}

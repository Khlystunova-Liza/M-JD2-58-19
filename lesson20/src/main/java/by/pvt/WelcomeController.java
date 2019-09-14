package by.pvt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    //метод который обрабатывает запрос приходящий на определенный адрес
    @RequestMapping(method = RequestMethod.GET)
    public String welcome(Model model){
        model.addAttribute("username","Java Developer");
        return "welcome";
    }

}

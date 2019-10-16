package springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String showHomePage(){
        return "index";
    }

//    @RequestMapping("/decks/")
//    public String showDecksPage(){
//        return "decks";
//    }

}

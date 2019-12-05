package hibernate.controller;

import hibernate.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    public String addCard(Model theModel)
    {
        return null;
    }



}

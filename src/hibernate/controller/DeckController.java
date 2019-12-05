package hibernate.controller;


import hibernate.entity.Deck;
import hibernate.service.CardService;
import hibernate.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/deck")
public class DeckController {

    @Autowired
    private DeckService deckService;




    @GetMapping("/delete")
    public String deleteDeck(@RequestParam("deckId") int theId)
    {
        deckService.deleteDeck(theId);

        return "redirect:/deck/list/";
    }

    @GetMapping("/list")
    public String listDecks(Model theModel)
    {
        List<Deck> deckList = deckService.getDecks();

        theModel.addAttribute("decks", deckList);

        return "list-decks";
    }

    @RequestMapping("/showAddDeckForm")
    public String showAddDeckForm(Model theModel)
    {
        Deck theDeck = new Deck();

        theModel.addAttribute("deck", theDeck);

        return "deck-form";
    }

    @RequestMapping("/showUpdateDeckForm")
    public String showUpdateDeckForm(@RequestParam("deckId") int theId, Model theModel)
    {
        Deck theDeck = deckService.getDeck(theId);

        theModel.addAttribute("deck", theDeck);

        return "deck-form";
    }

    @PostMapping("/save")
    public String saveDeck(@Valid @ModelAttribute("deck") Deck theDeck, BindingResult bindingResult,
                           HttpServletRequest request, Model theModel)
    {
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult);

            return "deck-form";
        }

        deckService.saveDeck(theDeck);

        return "redirect:/deck/list";
    }


    @GetMapping("/search")
    public String search(@RequestParam("searchTerm") String theSearchTerm, Model theModel)
    {
        List<Deck> matchingDecks = deckService.getDecksByName(theSearchTerm);

        theModel.addAttribute("decks", matchingDecks);

        return "list-decks";
    }

    public String showDetailForm(@RequestParam("deckId") int theId, Model theModel)
    {
        Deck theDeck = deckService.getDeck(theId);
        theModel.addAttribute("deck", theDeck);

        return "deck-detail-form";
    }



}

package hibernate.service;

import hibernate.dao.DeckDAO;
import hibernate.entity.Deck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DeckServiceImpl implements DeckService {

    @Autowired
    private DeckDAO deckDAO;

    @Override
    @Transactional
    public List<Deck> getDecks() {
        return deckDAO.getDecks();
    }

    @Override
    @Transactional
    public Deck getDeck(int id) {
        return deckDAO.getDeck(id);
    }

    @Override
    @Transactional
    public void saveDeck(Deck theDeck) {

        deckDAO.saveDeck(theDeck);
    }

    @Override
    @Transactional
    public void deleteDeck(int deckId) {
        deckDAO.deleteDeck(deckId);
    }

    @Override
    @Transactional
    public List<Deck> getDecksByName(String theSearchTerm) {
        return deckDAO.getDecksByName(theSearchTerm);
    }
}

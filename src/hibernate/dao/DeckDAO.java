package hibernate.dao;

import hibernate.entity.Deck;

import java.util.List;

public interface DeckDAO {
    List<Deck> getDecks();
    List<Deck> getDecksByName(String theSearchTerm);

    Deck getDeck(int id);



    void saveDeck(Deck theDeck);
    void deleteDeck(int deckId);
}

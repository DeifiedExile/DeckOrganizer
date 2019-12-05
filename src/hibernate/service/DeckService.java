package hibernate.service;

import hibernate.entity.Deck;

import java.util.List;

public interface DeckService {
    List<Deck> getDecks();

    Deck getDeck(int id);

    void saveDeck(Deck theDeck);

    void deleteDeck(int deckId);

    List<Deck> getDecksByName(String theSearchTerm);
}

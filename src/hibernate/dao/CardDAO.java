package hibernate.dao;

import hibernate.entity.Card;

import java.util.List;

public interface CardDAO {
    List<Card> getCards();

    void saveCard(Card theCard);

    Card getCard(int cardId);

    void deleteCard(int cardId);

    List<Card> getCardsByName(String theSearchTerm);


}

package hibernate.service;

import hibernate.entity.Card;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CardService {
    List<Card> getCards();

    void saveCard(Card theCard);

    Card getCard(int cardId);

    void deleteCard(int cardId);

    List<Card> getCardsByName(String theSearchTerm);

}

package hibernate.service;

import hibernate.dao.CardDAO;
import hibernate.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CardServiceImpl implements CardService{

    @Autowired
    private CardDAO cardDAO;


    @Override
    @Transactional
    public List<Card> getCards() {

        return cardDAO.getCards();
    }

    @Override
    @Transactional
    public void saveCard(Card theCard) {
        cardDAO.saveCard(theCard);
    }

    @Override
    @Transactional
    public Card getCard(int cardId) {
        return cardDAO.getCard(cardId);
    }

    @Override
    @Transactional
    public void deleteCard(int cardId) {
        cardDAO.deleteCard(cardId);
    }

    @Override
    public List<Card> getCardsByName(String theSearchTerm) {
        return cardDAO.getCardsByName(theSearchTerm);
    }
}

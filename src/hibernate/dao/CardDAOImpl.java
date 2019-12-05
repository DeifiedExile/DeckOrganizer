package hibernate.dao;


import hibernate.entity.Card;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.query.Query;
import java.util.List;

@Repository
public class CardDAOImpl implements CardDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Card> getCards() {
        Session session = sessionFactory.getCurrentSession();

        List<Card> cardList = session.createQuery("from Card", Card.class).getResultList();

        return cardList;
    }

    @Override
    public void saveCard(Card theCard) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(theCard);

    }

    @Override
    public Card getCard(int cardId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Card.class, cardId);
    }

    @Override
    public void deleteCard(int cardId) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Card where id = :doomedCardId");

        query.setParameter("doomedCardId", cardId);

        query.executeUpdate();

    }

    @Override
    public List<Card> getCardsByName(String theSearchTerm) {
        Session session = sessionFactory.getCurrentSession();

        theSearchTerm = "%" + theSearchTerm.toLowerCase() + "%";

        Query<Card> query = session.createQuery("from Card where lower(name) like :nameToSearch");

        query.setParameter("nameToSearch", theSearchTerm);

        return query.getResultList();

    }
}

package hibernate.dao;

import hibernate.entity.Deck;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class DeckDAOImpl implements DeckDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Deck> getDecks() {
        Session session = sessionFactory.getCurrentSession();


        List<Deck> deckList = session.createQuery("from Deck", Deck.class).getResultList();


        return deckList;
    }

    @Override
    public List<Deck> getDecksByName(String theSearchTerm) {
        Session session = sessionFactory.getCurrentSession();

        theSearchTerm = "%" + theSearchTerm.toLowerCase() + "%";

        Query<Deck> query = session.createQuery("from Deck where lower(name) like :nameToSearch");

        query.setParameter("nameToSearch", theSearchTerm);

        return query.getResultList();
    }

    @Override
    public Deck getDeck(int id) {
        Session session = sessionFactory.getCurrentSession();

        Deck aDeck = session.get(Deck.class, id);

        return aDeck;
    }

    @Override
    public void saveDeck(Deck theDeck) {
        Session session = sessionFactory.getCurrentSession();

        System.out.println(theDeck.getName());

        session.saveOrUpdate(theDeck);
    }

    @Override
    public void deleteDeck(int deckId) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Deck where id = :doomedDeckId");

        query.setParameter("doomedDeckId", deckId);

        query.executeUpdate();

    }
}

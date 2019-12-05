package hibernate;

import hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


public class HibernateApp {
    private SessionFactory factory;

    public HibernateApp()
    {
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Card.class)
                .addAnnotatedClass(Deck.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(DeckCard.class)
                .addAnnotatedClass(DeckCardId.class)
                .buildSessionFactory();

    }

    public static void main(String[] args) {
        HibernateApp app = new HibernateApp();

        try{
            int uid = app.createUser("Mr. Person");
            app.updateUserName(uid, "Mr. Alien");
            app.readUser(uid);
            int did = app.createDeck("deckzilla", uid);
            app.updateDeckFormat(did, "commander");
            int cid = app.createCard("testcard1");
            app.updateCardName(cid, "testcard2");
            app.readCard(cid);
            app.addCardToDeck(cid, did);
            app.readUser(uid);
            app.readDeck(did);
            app.readCard(cid);
            app.deleteCard(cid);
            app.deleteDeck(did);
            app.deleteUser(uid);

        }finally
        {

            app.close();
        }



    }


    public void close()
    {
        factory.close();
    }

    private void crudTemplate()
    {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        //TODO: CRUD

        session.getTransaction().commit();
    }
    private void getdecks()
    {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Deck> criteria = builder.createQuery(Deck.class);
        criteria.from(Deck.class);

        List<Deck> deckList = session.createQuery(criteria).getResultList();

        deckList.forEach(d -> System.out.println(d.getName()));

        session.getTransaction().commit();

    }

    //User Crud

    private int createUser(String name)
    {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        User user = new User();
        user.setUsername(name.strip());
        session.save(user);

        session.getTransaction().commit();

        return user.getId();
    }

    private void readUser(int userId)
    {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        User user = session.get(User.class, userId);

        System.out.println(user);


        session.getTransaction().commit();
    }

    private void updateUserName(int userId, String name)
    {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        User user = session.get(User.class, userId);
        if(user != null)
        {
            user.setUsername(name.strip());
        }
        System.out.println(user);
        session.getTransaction().commit();
    }
    private void deleteUser(int id)
    {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        User user = session.get(User.class, id);
        if(user != null)
        {
            session.delete(user);
        }


        session.getTransaction().commit();
    }

    private User getUser(int id)
    {
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        User user = session.get(User.class, id);

        return user;



    }

    //Card Crud

    private int createCard(String name)
    {
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        Card card = new Card(name);

        String q = "from Card c where c.name like :name";


        List<Card> result = session.createQuery(q)
                .setParameter("name", name)
                .getResultList();

        if(result.isEmpty()) {


            session.saveOrUpdate(card);
        }
        else
        {
            return result.get(0).getId();
        }




        session.getTransaction().commit();

        return card.getId();
    }

    private void readCard(int cardId)
    {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Card card = session.get(Card.class, cardId);

        System.out.println(card);


        session.getTransaction().commit();
    }

    private void updateCardName(int cardId, String name)
    {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Card card = session.get(Card.class, cardId);
        if(card != null)
        {
            card.setName(name.strip());
        }
        System.out.println(card);
        session.getTransaction().commit();
    }
    private void deleteCard(int cardId)
    {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Card card = session.get(Card.class, cardId);
        if(card != null)
        {
            session.delete(card);
        }


        session.getTransaction().commit();
    }

    private Card getCard(int cardId)
    {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Card card = session.get(Card.class, cardId);
        return card;
    }

    //deck crud

    private int createDeck(String name, int userId)
    {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        User user = session.get(User.class, userId);


        Deck deck = new Deck(name, user);

        session.save(deck);

        session.getTransaction().commit();

        return deck.getId();
    }

    private void readDeck(int deckId)
    {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Deck deck = session.get(Deck.class, deckId);

        System.out.println(deck);


        session.getTransaction().commit();
    }

    private void updateDeckFormat(int deckId, String format)
    {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Deck deck = session.get(Deck.class, deckId);
        if(deck != null)
        {
            deck.setFormat(format.strip());
        }
        System.out.println(deck);
        session.getTransaction().commit();
    }
    private void deleteDeck(int deckId)
    {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Deck deck = session.get(Deck.class, deckId);
        if(deck != null)
        {
            deck.setCards(null);
            deck.setUser(null);
            session.delete(deck);
        }


        session.getTransaction().commit();
    }



    //other crud
    private void addCardToDeck(int cardId, int deckId)
    {
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        Deck deck = session.get(Deck.class, deckId);
        Card card = session.get(Card.class, cardId);

        deck.addCard(card);


        session.getTransaction().commit();
    }

    private void removeCardFromDeck(int cardId, int deckId)
    {
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        Deck deck = session.get(Deck.class, deckId);
        Card card = session.get(Card.class, cardId);

        deck.removeCard(card);


        session.getTransaction().commit();
    }




}

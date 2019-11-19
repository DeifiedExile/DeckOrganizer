package hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="decks")
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deck_id")
    private int id;

    @Column(name = "deck_name")
    private String name;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "format")
    private String format;




    //need cascade all so that if it is deleted, it removes related entries from bridge table
    //one to many because bridge table has additional info
    //eager because i'll need all the cards associated with the deck
    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "deck",
    cascade = CascadeType.ALL)

    private List<DeckCard> cards = new ArrayList<DeckCard>();

    public Deck() {
    }

    public Deck(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public void setCards(List<DeckCard> cards) {
        this.cards = cards;
    }
    public void addCard(Card card)
    {
//        DeckCard deckCard = new DeckCard(this, card);
//        cards.add(deckCard);
//        card.getDecks().add(deckCard);
        DeckCard deckCard = new DeckCard(this, card);
        cards.add(deckCard);

    }

    public void removeCard(Card card)
    {
        for(Iterator<DeckCard> iterator = cards.iterator(); iterator.hasNext();)
        {
            DeckCard deckCard = iterator.next();


            if(deckCard.getDeck().equals(this) && deckCard.getCard().equals(card) && deckCard.getQuantity() < 2)
            {
                iterator.remove();
//                deckCard.getCard().getDecks().remove(deckCard);
                deckCard.setCard(null);
                deckCard.setDeck(null);
            }
            else if(deckCard.getDeck().equals(this) && deckCard.getCard().equals(card))
            {
                deckCard.setQuantity(deckCard.getQuantity() - 1);
            }
        }
    }


    public List<DeckCard> getCards() {
        return cards;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }



    @Override
    public String toString() {
        return "Deck{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", format='" + format + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Deck)) return false;
        Deck deck = (Deck) o;
        return getId() == deck.getId() &&
                Objects.equals(getName(), deck.getName()) &&
                getUser().equals(deck.getUser()) &&
                Objects.equals(getFormat(), deck.getFormat()) &&
                Objects.equals(cards, deck.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getUser(), getFormat(), cards);
    }
}

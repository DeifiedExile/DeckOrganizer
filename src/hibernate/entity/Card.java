package hibernate.entity;






import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="card_id")
    private int id;


    @Column(name="card_name")
    private  String name;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "card",
            cascade = CascadeType.ALL

    ) //need cascade all so that if it is deleted, it removes related entries from bridge table
    //one to many because bridge table has additional info
    //lazy because i dont need every deck each time i check this card
    private List<DeckCard> decks = new ArrayList<>();

    public Card() {
    }

    public Card(String name) {
        this.name = name;
    }

    public void addDeck(Deck deck)
    {
        DeckCard deckCard = new DeckCard(deck, this);
        decks.add(deckCard);
        deck.getCards().add(deckCard);
    }

    public void removeDeck(Deck deck)
    {
        for(Iterator<DeckCard> iterator = decks.iterator(); iterator.hasNext();)
        {
            DeckCard deckCard = iterator.next();

            if(deckCard.getCard().equals(this) && deckCard.getDeck().equals(deck))
            {
                iterator.remove();
                deckCard.getDeck().getCards().remove(deckCard);
                deckCard.setCard(null);
                deckCard.setDeck(null);
            }
        }
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

    public List<DeckCard> getDecks() {
        return decks;
    }

    public void setDecks(List<DeckCard> decks) {
        this.decks = decks;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return getId() == card.getId() &&
                Objects.equals(getName(), card.getName()) &&
                Objects.equals(getDecks(), card.getDecks());
    }



    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDecks());
    }
}

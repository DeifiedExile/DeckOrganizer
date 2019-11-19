package hibernate.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "deck_card")
public class DeckCard {

    @EmbeddedId
    private DeckCardId key;

    @Column(name = "quantity")
    private int quantity;

    //Took me a while to get this to work at all
    //Lazy because its only needed when specifically called for upon creation
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("deckId")
    private Deck deck;
    //Lazy because its only needed when specifically called for upon creation
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("cardId")
    private Card card;

    public DeckCard() {
    }

    public DeckCard(int quantity, Deck deck, Card card) {
        this.key = new DeckCardId(deck.getId(), card.getId());
        this.quantity = quantity;
        this.deck = deck;
        this.card = card;
    }

    public DeckCard(Deck deck, Card card) {
        this.key = new DeckCardId(deck.getId(), card.getId());
        this.deck = deck;
        this.card = card;
    }

    public DeckCardId getKey() {
        return key;
    }

    public void setKey(DeckCardId key) {
        this.key = key;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeckCard)) return false;
        DeckCard deckCard = (DeckCard) o;
        return getQuantity() == deckCard.getQuantity() &&
                getKey().equals(deckCard.getKey()) &&
                Objects.equals(getDeck(), deckCard.getDeck()) &&
                Objects.equals(getCard(), deckCard.getCard());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey(), getQuantity(), getDeck(), getCard());
    }
}



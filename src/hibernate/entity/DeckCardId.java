package hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DeckCardId implements Serializable {


    @Column(name = "deck_id")
    private Integer deckId;
    @Column(name = "card_id")
    private Integer cardId;

    public DeckCardId() {
    }

    public DeckCardId(Integer deckId, Integer cardId) {
        this.deckId = deckId;
        this.cardId = cardId;
    }

    public Integer getDeckId() {
        return deckId;
    }

    public void setDeckId(Integer deckId) {
        this.deckId = deckId;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeckCardId)) return false;
        DeckCardId that = (DeckCardId) o;
        return deckId.equals(that.deckId) &&
                cardId.equals(that.cardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deckId, cardId);
    }
}

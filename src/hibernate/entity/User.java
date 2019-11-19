package hibernate.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_name")
    private String username;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Deck> decks;

    public User() {
    }

    public User(String username, List<Deck> decks) {
        this.username = username;
        this.decks = decks;
    }

    public void addDeck(Deck aDeck)
    {
        if(decks == null)
        {
            decks = new ArrayList<>();
        }
        decks.add(aDeck);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Deck> getDecks() {
        return decks;
    }

    public void setDecks(List<Deck> decks) {
        this.decks = decks;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", decks= ");
        StringJoiner deckList = new StringJoiner(", ", " ", "");

        for(Deck deck : decks)
        {
            deckList.add(deck.getName());
        }
        output.append(deckList.toString());

        output.append('}');
        return output.toString();
    }
}

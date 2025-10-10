//Tuğberk Albayrak
//package cardgame;

/**
 * Player - Maintains the name and the cards held by one player.
 */
public class Player {
    private String name;
    private Cards hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Cards(false);
    }

    public String getName() {
        return name;
    }

    public void add(Card c) {
        hand.addTopCard(c);
    }

    public Card playCard() {
        return hand.getTopCard(); 
    }
    
}

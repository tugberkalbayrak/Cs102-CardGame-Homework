package cardgame;

import java.util.ArrayList;

// Cardgame
// author:
// date:
public class CardGame
{
    // properties
    Cards             fullPack;
    ArrayList<Player> players;
    ScoreCard         scoreCard;
    Cards[]           cardsOnTable;
    int               roundNo;
    int               turnOfPlayer;
    
    // constructors
    public CardGame( Player p1, Player p2, Player p3, Player p4)
    {
      
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        scoreCard = new ScoreCard(players.size());
        fullPack = new Cards();
        fullPack.shuffle();
        cardsOnTable = new Cards[players.size()];
        for (int i = 0; i < cardsOnTable.length; i++) {
            cardsOnTable[i] = new Cards();
        }
        roundNo = 1;
        turnOfPlayer = 0;
      
    }
    
    // methods
    public boolean playTurn( Player p, Card c)
    {
        if(!isTurnOf(p))
          return false;

        cardsOnTable[turnOfPlayer].addCard(card);
        player.removeCard(card);

        
        turnOfPlayer = (turnOfPlayer + 1) % players.size();

        
        if (turnOfPlayer == 0) {
            updateScores();
            roundNo++;
        }

        return true;

    }
    
    public boolean isTurnOf(Player player) {
        return players.get(turnOfPlayer).equals(player);
    }
    
    public boolean isGameOver() {
      
        for (Player player : players) {
            if (!player.getHand().isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    public int getRoundNo() {
        return roundNo;
    }

    // Whose turn is it right now?
    public int getTurnOfPlayerNo() {
        return turnOfPlayer;
    }
    
    public String getName( int playerNumber)
    {
        // ToDo
        return "Not yet implemented";
    }
    
    public int getRoundNo()
    {
        // ToDo
        return -1;
    }
    
    public int getTurnOfPlayerNo()
    {
        // ToDo
        return -1;
    }
    
    public Player[] getWinners()
    {
        // ToDo
        return null;
    }
    
    public String showScoreCard()
    {
        return scoreCard.toString();
    }
}

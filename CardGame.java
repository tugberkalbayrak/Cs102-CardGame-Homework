

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
        fullPack = new Cards(true);
        roundNo = 1;
        turnOfPlayer = 0;
        fullPack.shuffle();
        cardsOnTable = new Cards[players.size()];
        for (int i = 0; i < cardsOnTable.length; i++) {
            players.get(i % players.size()).add(fullPack.getTopCard());
        }
    }
    
    
    public boolean playTurn( Player p, Card c)
    {
        if(isGameOver() || !isTurnOf(p))
            return false;

        cardsOnTable[turnOfPlayer].addTopCard(c);
        turnOfPlayer++;

        if(turnOfPlayer == players.size()){
            int highestCardValue = Integer.MIN_VALUE;
            int winner = Integer.MIN_VALUE;


            for(int i = 0; i < cardsOnTable.length; i++){
                Card playedCard = cardsOnTable[i].getTopCard();

                if(playedCard.getFaceValue() > highestCardValue){
                    highestCardValue = playedCard.getFaceValue();
                    winner = i;
                }

            }

            scoreCard.update(winner, 1);

            turnOfPlayer = 0;
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
    
    

  
    public int getScore(int playerNumber) {
        return scoreCard.getScore(playerNumber);
    }


    public String getName(int playerNumber) {
        return players.get(playerNumber).getName();
    }


    
    public int getRoundNo() {
        return roundNo;
    }

   
    public int getTurnOfPlayerNo() {
        return turnOfPlayer;
    }
    
    public Player[] getWinners() {
   
    int[] winnerIndices = scoreCard.getWinners();

    
    Player[] winners = new Player[winnerIndices.length];
    for (int i = 0; i < winnerIndices.length; i++) {
        winners[i] = players.get(winnerIndices[i]);
    }


    return winners;
}
    
    public String showScoreCard()
    {
        return scoreCard.toString();
    }
}

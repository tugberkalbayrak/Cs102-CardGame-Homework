//Tuğberk Albayrak
//package cardgame;

/**
 * ScoreCard - Maintains the scores for a set of players.
 */
public class ScoreCard {
    private int[] scores;

    public ScoreCard(int noOfPlayers) {
        scores = new int[noOfPlayers];
        for (int i = 0; i < noOfPlayers; i++) {
            scores[i]= 0;
        }
    }

    public void update(int playerNo, int delta) {
        scores[playerNo] +=delta;
    }

    public int getScore(int playerNo) {
        return scores[playerNo];
    }

    public String toString() {
    String s = "Score Card\n";
    s += "_____________\n";
    for (int playerNo = 0; playerNo < scores.length; playerNo++) {

        s= s + playerNo + "\t" + scores[playerNo] + "\n";
    }
    s += "_____________\n";
    return s;
}


    public int[] getWinners() {
        int max = scores[0];
        
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        
        int countForWinners = 0;
      
        for (int s : scores) {
            if (s == max) 
                countForWinners++;
        }

        
        int[] winners = new int[countForWinners];
        int index = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == max) {
                winners[index] = i;
                index++;
            }
        }

        return winners;
    }
}

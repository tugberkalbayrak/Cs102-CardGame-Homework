//Murat Esendemir

/**
 * Card - a single playing card
 * @author : Murat Esendemir 
 * @version
 */
public class Card
{
    // constants - to do in lectures
    final String[] SUITS = { "Hearts", "Diamonds", "Spades", "Clubs"};
    final String[] FACES = { "A", "2", "3", "4", "5",
                             "6", "7", "8", "9", "10",
                             "J", "Q", "K"};
    
    final int NOOFCARDSINSUIT = 13;
    
    // properties - to do in lectures
    int  cardNo;
    
    // constructors  - to do in lectures
    public Card( int faceValue, int suit )
    {
        cardNo = faceValue + suit * NOOFCARDSINSUIT;
    }
    
    public Card( int cardNumber)
    {
        cardNo = cardNumber;
    }
    
    public int getFaceValue()
    {
        return cardNo % NOOFCARDSINSUIT;
    }
    
    public int getSuit()
    {
        return cardNo / NOOFCARDSINSUIT;
    }
    
    public String toString()
    {
        return FACES[ getFaceValue() ] + " of " + SUITS[ getSuit() ];
    }
    
    public boolean equals( Card c)
    {
        if(this.cardNo == c.cardNo){
            return true;
        }
        return false;
    }
    
    public int compareTo( Card c)
    {
        if(this.getSuit() != c.getSuit()){
            return this.getSuit() - c.getSuit();
        } else if(this.getFaceValue() != c.getFaceValue()){
            return this.getFaceValue() - c.getFaceValue();
        } else {
            return 0;
        }
    }
}
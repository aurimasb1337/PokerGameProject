package PokerGame;


public class Card
{
     private int suit;    //1 = Hearts, 2 = Diamonds, 3 = Clubs, 4 = Spades || Easier to use than String types in cycles.
     private int value;  //1 = ace (for straight), 11 = Jack ... 13=King

     //Constructor for deck to generate random cards
     public Card(int suit, int value)
     {
          this.suit = suit;
          this.value = value;
     }
     public void setSuit(int suit)
     {
          this.suit = suit;
     }

     public void setValue(int value)
     {
          this.value = value;
     }
     public int getSuit()
     {
          return this.suit;
     }

     public int getValue()
     {
          return this.value;
     }



     public String getCardName()  // returns string, e.g., "Ace of Hearts"
     {
          String name = "";
          if (value == 1)
               name = "Ace of ";
          else if (value == 11)
               name = "Jack of ";
          else if ( value == 12)
               name = "Queen of ";
          else if (value == 13)
               name = "King of ";
          else                         // Use basic int value
               name = value + " of ";

          
 // add suit onto name string.
          if (suit == 1)
               name += "Hearts";
          else if ( suit == 2)
               name += "Diamonds";
          else if ( suit == 3)
               name += "Clubs";
          else
               name += "Spades";
          return name;
     }
}
package PokerGame;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Hand //class to store 5 table cards and evaluate hands.
 {
     private Card[] cards;
     private Deck deck;
     private int suits[];  
     private int values[]; 

     public Hand()
     {
          cards = new Card[5];
          suits = new int[5];      
          values = new int[14];  
          deck = new Deck();
     }

     public void newHand()
     {
          deck.shuffle();
          for (int i = 0; i < 5; i++)
          {
               cards[i] = deck.deal();
               suits[cards[i].getSuit()]++ ;
               values[cards[i].getValue()]++;
          }
               sort();
     }

     public void updateHand(boolean[] x)
     {
          for (int i = 0; i < 5; i++)
          if ( !x[i])
          {
              
               suits[cards[i].getSuit()]-- ;
               values[cards[i].getValue()]--;
               
               cards[i] = deck.deal();
               
               suits[cards[i].getSuit()]++ ;
               values[cards[i].getValue()]++;
          }
          sort();
     }

     public String[] getHand()
     {

          String[] cardsInHand = new String[5];
          for (int i = 0; i < 5; i++)
               cardsInHand[i] = cards[i].getCardName();
          return cardsInHand;
     }

     private void sort()  
     {
          int max; 
          for (int place = 4; place > 0; place--)
          {
               max = 0;
              
               
               for (int i = 1; i <= place; i++)
               if ( cards[i].getValue() > cards[max].getValue())
                    max = i;
              
               Card temp = cards[place];
               cards[place] = cards[max];
               cards[max] = temp;
          }
     }

     public int evaluateHand()
     {
          if (royalFlush()) 
               return 800;
          else if (straightFlush()) 
               return 50;
          else if (fourOfAKind()) 
               return 25; 
          else if (fullHouse()) 
               return 9;
          else if (flush())
               return 6;
          else if (straight())
               return 4;
          else if (threeOfAKind()) 
               return 3;
          else if (twoPair())
               return 2;
          else if (pair())  
               return 1;
          
          
          else return -1;   // losing hand
     }

     private boolean royalFlush()
     {
         
          boolean sameSuit = false;  
          boolean isRoyalty = false;
          for(int i = 1; i <=4; i++)
               if (suits[i] == 5) 
                    sameSuit = true;
          isRoyalty = (values[1] == 1 &&
                              values[10] ==1 &&
                              values[11] ==1 &&
                              values[12] == 1 &&
                              values[13] == 1); 
          return (sameSuit && isRoyalty); 
     }

     private boolean straightFlush()
     {
          boolean sameSuit = false;
          boolean ranksInOrder = false;
          for(int i = 1; i <=4; i++)
               if (suits[i] == 5)
                    sameSuit = true;  // same suit
          // cards in sequence
          ranksInOrder =
          cards[1].getValue() == (cards[0].getValue() + 1) &&
          cards[2].getValue() == (cards[0].getValue() + 2) &&
          cards[3].getValue() == (cards[0].getValue() + 3) &&
          cards[4].getValue() == (cards[0].getValue() + 4);
          return (sameSuit && ranksInOrder);
     }

     private boolean flush()
     {
          for(int i = 1; i <=4; i++)
               if (suits[i] == 5)  // 
                    return true;
          return false;
     }

     private boolean fourOfAKind()
     {
          for(int i =1 ; i <= 13; i++)
               if (values[i] == 4)
                    return true;
          return false;
     }

     private boolean fullHouse()
     {
          boolean three= false;
          boolean two= false;
          for(int i =1 ; i <= 13; i++)
               if (values[i] == 3)  // three of one kind
                    three= true;
               else if (values[i] ==2) 
                    two = true;
          return  two && three; 
     }

     private boolean straight()
     {
         
          return
         
           (cards[1].getValue() == (cards[0].getValue() + 1) &&
          cards[2].getValue() == (cards[0].getValue() + 2) &&
          cards[3].getValue() == (cards[0].getValue() + 3) &&
          cards[4].getValue() == (cards[0].getValue() + 4))  ||
          
           (values[1] == 1 && 
          values[10] ==1 &&  
          values[11]==1 &&  
          values[12] == 1 && 
          values[13] == 1); 
     }

     private boolean threeOfAKind()
     {
          for(int i =1 ; i <= 13; i++)
               if (values[i] == 3)
                    return true;
          return false;
     }

     private boolean twoPair()
     {
          int count = 0;
          for( int i = 1; i <= 13; i++)
               if(values[i] == 2)   // count the number of pairs
                    count++;
          return (count == 2);
     }

     private boolean pair() // 
     {
          if (values[1] == 2) 
               return true;
          for( int i = 11; i <= 13; i++) // pair of Jacks or higher
               if(values[i] ==2)
                    return true;
          return false;
          }
     }
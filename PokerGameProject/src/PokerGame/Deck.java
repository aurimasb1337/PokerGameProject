package PokerGame;

import java.util.*;   
public class Deck // class for generating random cards
{
     private Card deck[];
     private int buffer;  // holds position of next card to be dealt
     public Deck()
     {
          deck =new Card[53]; // Uses positions 1 to 52

          for (int rank=1; rank <= 13; rank++)
          {
               // sort cards by value and suit
               deck[rank]    = new Card(1,rank); 
               deck[rank+13] = new Card(2,rank); 
               deck[rank+26] = new Card(3,rank); 
               deck[rank+39] = new Card(4,rank); 
          }
          buffer = 1;
     }

     public Card deal()
     {
          if ( buffer > 52)  
               shuffle();
          Card card = deck[buffer];
          buffer++;
          return card;
     }
     
     
     public void shuffle() //shuffle cards using random utility and for loop
     {
          Random randomNumber = new Random();
          for (int i = 1; i <= 52; i++)
          {
               
               int rand= randomNumber.nextInt(52) + 1;
               //swap deck[i] with deck[m]
               Card temp = deck[i];
               deck[i] = deck[rand];
               deck[rand] = temp;
          }
          buffer = 1; 
     }

 
     }
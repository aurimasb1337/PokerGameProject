package PokerGame;

public class PokerGame // Class where we other class object meet
 {
     private int bankroll;
     private int bet;
     private Hand hand;
     private Player player;
     private boolean[] holdCards;

     public PokerGame(int bet, int bankroll, Player pl)
     {
          this.bankroll = bet;
          this.bet = bankroll;
          this. player = pl;
          this. hand = new Hand();
          this. holdCards = new boolean[5];
     }

     public void viewInitialHand()
     {
          hand.newHand();
          player.displayHand(hand.getHand());
		  int reward = hand.evaluateHand();
		
		  player.displayResults(reward);
     }

     public void discardOrHoldCards()
     { 
          player.getDiscard(holdCards);
          hand.updateHand(holdCards);
          player.displayHand(hand.getHand());
          int reward = hand.evaluateHand();
     
          player.displayResults(reward); 
     }
 }
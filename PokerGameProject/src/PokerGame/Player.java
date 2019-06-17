package PokerGame;

import java.util.*;
 public class Player
 {
     private Scanner  input;
     int bankroll=0; //starting stack
     private PokerGame pokerGame;
     int bet;
     int deposit;
     

     Player()
     {
          input = new Scanner(System.in);
     }
     void makeDeposit()
     {
 
          do
          {
               System.out.println("How many € would you like to deposit?");
               deposit = input.nextInt();
          } while (deposit <= 0);

          bankroll+=deposit;
          System.out.println("Bankroll: "+ bankroll+ " €");
          System.out.println();
     }

     public void betAndPlay() throws IllegalArgumentException
     {
    	  if (bankroll<1) 
        	  throw new IllegalArgumentException("Insufficent balance!"); //forbids playing without money
          do
          {
        	
        	
              
               System.out.println("Place your bet (not more than half your bankroll!): ");
               bet = input.nextInt();
          } while (bet>=bankroll/2); // precaution in order to have a positive balance after discarding/holding cards.

         
          pokerGame = new PokerGame(bet, bankroll, this);
          pokerGame.viewInitialHand();
          pokerGame.discardOrHoldCards();

     }

     public void displayHand(String[] handString)
     {
          System.out.println("----------------- Deck Cards -----------------");
          for(int i = 0; i < 5; i++)
               System.out.println((i+1) + ".  " + handString[i]);
          System.out.println("---------------------------------------------------");
          System.out.println();
     }

	
		  public void displayResults(int reward)
		     {
		          String nameOfHand = "Lose";
		          if (reward == 800)
		               nameOfHand = "Royal Flush";
		          else if (reward == 50)
		               nameOfHand = "Straight Flush";
		          else if (reward == 25)
		               nameOfHand = "Four of a Kind";
		          else if (reward == 9)
		               nameOfHand = "Full House";
		          else if (reward == 6)
		               nameOfHand = " Flush";
		          else if (reward == 4)
		               nameOfHand = "Straight ";
		          else if (reward == 3)
		               nameOfHand = "Three of a Kind";
		          else if (reward == 2)
		               nameOfHand = "Two Pair";
		          else if (reward == 1)
		               nameOfHand  = " Pair of Jacks or Better";

		          if (reward > 0)
		          {
		        	  bankroll+=(bet*reward);
		        	  System.out.println("Congratulations! You have won: " + reward*bet + "€ From your " +bet+ "€ bet.");
					  System.out.println("Winning hand:" + nameOfHand);
					  System.out.println("Your current bankroll: " + bankroll + "€");
		          }
		          else if (reward<1) {
		        	  bankroll= bankroll -bet;
		          System.out.println("Sorry, you have lost your bet of " + bet+ " €");
		          System.out.println("Your current bankroll: " + bankroll + "€");
		     }}
		 
	 
     public void getDiscard(boolean[] x)
     {
    	  String ans;

          for (int i = 0; i < 5; i++)
          {
               do
               {
                    System.out.print("Hold (y) or Discard (x) card number "+(i+1)+": ");
                    ans = input.next();

                    if (ans.equals("y") )
                         x[i] = true; // hold
                    else if (ans.equals("y") )
                         x[i] = false; // discard
               }while (!(ans.equals("y") || ans.equals("x")));

          }
         
     }



     public void quit()
     {
        
          System.out.println("\n******Game Over****** \n");
          if (bankroll > 0)
               System.out.println("Returned: "+bankroll+" €");
          else
               System.out.println("No € remain, please deposit");
          System.out.println("\n*********************");
     }

     public void menu()
     {
          String userInput;
          do
          {
               System.out.println("Choose");
               System.out.println("[1] Play Jacks Or Better");
               System.out.println("[2] Make a fast deposit ");
               System.out.println("[x] Quit");
               System.out.print("Your choice: ");
               userInput = input.next();
               if (userInput.equals("1"))
                    betAndPlay();
               else if (userInput.equals("2"))
            	   makeDeposit();
          }while ((!(userInput.equals("x") ) && bankroll >0));
     }

   
 }

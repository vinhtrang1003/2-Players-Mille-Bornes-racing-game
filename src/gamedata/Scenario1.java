/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedata;


/**
 *
 * @author Vinh
 */
public class Scenario1 
{
    /*
    This class contain another main which keep asking for each move a user want
    to make and return score and will exit if 1 player win */
    
     public static void main(String[] args) 
    {
        // this Scenario1 will test
        // The program needs to check for ending the hand because there are no more cards to draw.
       Game game1 = new Game();
       game1.First6Cards();
       
       game1.removedeck(); // i use this fuction to clear the whole deck in game1
       
       game1.PrintHand(1);
       game1.P1DrawsCard(); // should display no more card to draw
       
       game1.PrintHand(2); 
       game1.P2DrawsCard(); // should display no more card to draw
       
       System.out.println("P1 use go and P2 use go");
       game1.TryMove(1, 2);
       game1.TryMove(2, 4);
       game1.PrintAllScore(); // should print 0 0
       
       System.out.println("P1 use 75 and P2 use 50");
       game1.TryMove(1, 1);
       game1.TryMove(2, 0);
       game1.PrintAllScore(); // should print 75 50
       
       System.out.println("P1 P2 discard the rest of 5 cards ");
       for (int i = 0 ; i < 5 ; i++)
       {
       game1.discardfromhand(1, 0);
       game1.discardfromhand(2, 0); // this will display 2 error messages because both only have 4 cards on hand
       }
       System.out.println("Check for end game and see who won? ");
       game1.isGameOver();
       
       /*
  	 A game is still just one hand and with 2 players.
 	 The program needs to check for ending the hand because there are no more cards to draw.
         in the actual game i can use game1.usGameOver() for a while loop to check for ending of hand
         as you can see the program can check for empty deck as well as empty hand.
       */
    }
    
}


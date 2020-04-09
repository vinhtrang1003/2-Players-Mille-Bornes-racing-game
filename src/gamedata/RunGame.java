/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedata;

import java.util.Scanner;
/**
 *
 * @author Vinh
 */
public class RunGame 
{
    /*
    This class contain another main which keep asking for each move a user want
    to make and return score and will exit if 1 player win */
    
     public static void main(String[] args) 
    {
       Game secondgame = new Game();
       secondgame.shuffle();
       secondgame.First6Cards();
       
    
       int g = 0;
       
       
       while (g == 0)
       {
       Scanner reader = new Scanner(System.in); 
       
       if (secondgame.Player1.HandSize()<7)
       {
       System.out.println("----------------------- Player 1 -----------------------");
       secondgame.P1DrawsCard();
       }
       
       secondgame.PrintHand(1);
       
       System.out.print("Do you want to discard a card? (0 no / 1 yes) : ");
       int d = reader.nextInt();
       if (d == 1)
       {
           System.out.print("Choose a card to discard: ");
           d = reader.nextInt();
           secondgame.discardfromhand(1, d);
           secondgame.PrintDiscardDeck();
       }
       else
       {
       System.out.print("Choose a card to play: ");
       int i = reader.nextInt();
       secondgame.TryMove(1, i);
       }
       
       g = secondgame.isGameOver();
       secondgame.PrintAllScore();
       
            if (g == 0 && secondgame.Player1.HandSize()<7)
            {
                
                if (secondgame.Player2.HandSize()<7)
                {
                System.out.println("----------------------- Player 2 -----------------------");
                secondgame.P2DrawsCard();
                }
                
                while (secondgame.Player2.HandSize()!= 6)
                {
                secondgame.PrintHand(2);
                
                System.out.print("Do you want to discard a card? (0 no / 1 yes) : ");
                d = reader.nextInt();
                if (d == 1)
                {
                System.out.print("Choose a card to discard: ");
                d = reader.nextInt();
                secondgame.discardfromhand(2, d);
                secondgame.PrintDiscardDeck();
                }
                else
                {
                System.out.print("Choose a card to play: ");
                int i = reader.nextInt();
                secondgame.TryMove(2, i);
                }
                
                g = secondgame.isGameOver();
                secondgame.PrintAllScore();
                }
            }
           
       }
       
       
 
    }
    
}

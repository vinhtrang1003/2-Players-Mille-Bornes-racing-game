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
public class Scenario2 
{
    
    
     public static void main(String[] args) 
    {
        // use card library
        Card d25 = new Distance("D25", 25);
        Card d50 = new Distance("D50", 50);
        Card d75 = new Distance("D75", 75);
        Card d100 = new Distance("D100", 100);
        Card d200 = new Distance("D200", 200);
        
        Card Go = new Remedies("Go", 1);
        Card Repair = new Remedies("Repair", 2);
        Card Gasoline = new Remedies("Gasoline", 3);
        Card SpareTire = new Remedies("SpareTire", 4);
        Card EndOfLimit = new Remedies("EndOfLimit", 5);
        
        
        Card Accident = new Hazards("Accident", 1);
        Card OutOfGas = new Hazards("OutOfGas", 2);
        Card FlatTire = new Hazards("FlatTire", 3);
        Card Stop = new Hazards("Stop", 4);
        Card SpeedLimit = new Hazards("SpeedLimit", 5);
        
        
        
        
        Card DrivingAce = new Safeties("DrivingAce", 1);
        Card FuelTank = new Safeties("FuelTank", 2);
        Card PunctureProof = new Safeties("PunctureProof", 3);
        Card RightOfWay = new Safeties("RightOfWay", 4);
        
        
        Game game2 = new Game();
        
       game2.removedeck();
       
       game2.Player1.AddCard(Go);
       game2.Player1.AddCard(d100);
       game2.Player1.AddCard(d100);
       game2.Player1.AddCard(d100);
       game2.Player1.AddCard(d100);
       game2.Player1.AddCard(d100);
       game2.Player1.AddCard(d100);
       game2.Player1.AddCard(d100);
       game2.Player1.AddCard(DrivingAce);
       game2.Player1.AddCard(FuelTank);
       
       game2.Player2.AddCard(Go);
       game2.Player2.AddCard(d200);
       game2.Player2.AddCard(d200);
       game2.Player2.AddCard(d200);
       game2.Player2.AddCard(d100);
       game2.Player2.AddCard(d100);
       game2.Player2.AddCard(d100);
       game2.Player2.AddCard(d100);
       game2.Player2.AddCard(DrivingAce);
       game2.Player2.AddCard(FuelTank);
       
       game2.PrintHand(1);
       game2.PrintHand(2); 
       
       System.out.println("P1 use go and P2 use go");
       game2.TryMove(1, 0);
       game2.TryMove(2, 0); 
       
       game2.PrintHand(1);
       game2.PrintHand(2); 
       
       System.out.println("P1 use d100");
       game2.TryMove(1, 0); 
       System.out.println("P1 use d100");
       game2.TryMove(1, 0); 
       System.out.println("P1 use d100");
       game2.TryMove(1, 0); 
       System.out.println("P1 use d100");
       game2.TryMove(1, 0); 
       System.out.println("P1 use d100");
       game2.TryMove(1, 0); 
       System.out.println("P1 use d100");
       game2.TryMove(1, 0); 
       
       System.out.println("P2 discard first card");
       game2.discardfromhand(2, 0);
       System.out.println("P2 discard first card");
       game2.discardfromhand(2, 0);
       System.out.println("P2 discard first card");
       game2.discardfromhand(2, 0);
       System.out.println("P2 discard first card");
       game2.discardfromhand(2, 0);
       System.out.println("P2 discard first card");
       game2.discardfromhand(2, 0);
       System.out.println("P2 discard first card");
       game2.discardfromhand(2, 0);
      
       game2.PrintHand(1);
       game2.PrintHand(2);
       
       System.out.println("P1 use Driving Ace");
       game2.TryMove(1, 1); 
       System.out.println("Above said no more card to draw because after each safety play you draw 1 card");
       System.out.println("P1 use Fuel Tank");
       game2.TryMove(1, 1); 
       System.out.println("Above said no more card to draw because after each safety play you draw 1 card");
       System.out.println("P1 use d100");
       game2.TryMove(1, 0); 
       
       game2.PrintHand(1);
       game2.PrintHand(2);
       
       game2.isGameOver();
       game2.PrintTotalScore();
       
       System.out.println("P1 2400 points break down: ");
       System.out.println("700km traveled + 200 for 2 safeties + 500 For shutout + 300 for safetrip + 300 for delayed win + 400 win = 2400 ");
       
        /*
  	 To avoid a lot of repetition, these scenarios do not necessarily reach the end of the hand.
	The program should now follow the scoring rules to indicate who wins.
       */
       
    }
    
}

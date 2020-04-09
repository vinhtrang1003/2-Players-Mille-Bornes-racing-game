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
public class Scenario4 
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
        
        
       Game game4 = new Game();
        
       game4.removedeck();
       
       System.out.println("P1 use Go");
       game4.Player1.AddCard(Go);
       game4.TryMove(1, 0); 
       game4.PrintHand(1);
       System.out.println("P1 use d200");
       game4.Player1.AddCard(d200);
       game4.TryMove(1, 0);
       
        System.out.println("P2 use Accident");
       game4.Player2.AddCard(Accident);
       game4.TryMove(2, 0); 
       
       System.out.println("P1 use RightOfWay");
       game4.Player1.AddCard(RightOfWay);
       game4.TryMove(1, 0);
       game4.PrintHand(1);
       
       System.out.println("P1 use Repair");
       game4.Player1.AddCard(Repair);
       game4.TryMove(1, 0);
       game4.PrintHand(1);
       
       System.out.println("P1 use d200");
       game4.Player1.AddCard(d200);
       game4.TryMove(1, 0);
       game4.PrintAllScore();
       
       /*
       System.out.println("P2 use Stop");
       game4.Player2.AddCard(Stop);
       game4.TryMove(2, 0); 
       game4.PrintHand(1);
       game4.PrintAllScore();
       System.out.println("P1 use d200");
       game4.Player1.AddCard(d200);
       game4.TryMove(1, 0);
       
       
       System.out.println("P1 use RightOfWay");
       game4.Player1.AddCard(RightOfWay);
       game4.TryMove(1, 1);
       System.out.println("P1 use d200");
       game4.TryMove(1, 0);
       game4.PrintAllScore();
       System.out.println("P2 use speedlimit");
       game4.Player2.AddCard(SpeedLimit); // can't use because p1 has RightOfWay
       game4.TryMove(2, 0);
       game4.discardfromhand(2, 0);
       game4.PrintAllScore();
       System.out.println("P2 use Accident");
       game4.Player2.AddCard(Accident);
       game4.TryMove(2, 0);
       game4.PrintHand(1);
       System.out.println("P1 use Repair");
       game4.Player1.AddCard(Repair);
       game4.TryMove(1, 0);
       game4.PrintHand(1);
       System.out.println("P1 use Go");
       game4.Player1.AddCard(Go);
       game4.TryMove(1, 0);
       game4.PrintHand(1);
       System.out.println("P1 use d100");
       game4.Player1.AddCard(d100);
       game4.TryMove(1, 0);
       System.out.println("P1 use d100");
       game4.Player1.AddCard(d100);
       game4.TryMove(1, 0);
       
       System.out.println("P1 use d100");
       game4.Player1.AddCard(d100);
       game4.TryMove(1, 0);
       
       game4.isGameOver();
    /*
  	The scenarios should include the playing of hazards, remedies and safeties.
       this demonstrate that the program works with those type of cards
	The scenarios should be from different equivalence classes. You should be able to imagine how they might fail independently of each other.
       user can choose Scenario3 or simply RunGame to further test the program
       
       
      */
}
}

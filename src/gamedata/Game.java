/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Vinh
 */
public class Game 
{
    // create an array to hold the deck 
    private ArrayList<Card> deck;
    
    // create an array to hold the discard from hand deck
    private ArrayList<Card> discard_deck;
  
    // For now we only need 2 players and no CPU player yet 
    PlayerData Player1 ;
    PlayerData Player2 ;
    
    //to define winner of the game and so on
    static int PLAYER1 = 1;
    static int PLAYER2 = 2;
    
    static int MaxKm = 700;
    
    
    PlayerTable P1TAB = new PlayerTable();
    PlayerTable P2TAB = new PlayerTable();
    

    
    public Game() 
    {
        deck = new ArrayList<>();
        discard_deck = new ArrayList<>();
        
        // I do hard code for player name P1 P2 to make the program simple
        // later i can ask for player name input
        Player1 = new PlayerData("P1");
        Player2 = new PlayerData("P2");
        createDeck();
    }
    
    // create deck not included all cards like the full version of the game
    
    private void createDeck() 
    {
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
        
        for (int i = 0; i < 10; i++) 
        {
            deck.add(d25);
            deck.add(d50);
            deck.add(d75);
            deck.add(d100);
            deck.add(Go);
        }
        deck.add(d100); // 12 x 100 km cards
        deck.add(d100);
        
        for (int i = 0; i < 4; i++) 
        {
            deck.add(d200); // 4x d200
            deck.add(Go); // 14 x Go cards
            deck.add(Repair);
            deck.add(Gasoline);
            deck.add(SpareTire);
            deck.add(EndOfLimit);
        }
        deck.add(Repair); // 6x Repair cards
        deck.add(Repair);
        deck.add(Gasoline); // 6x gas
        deck.add(Gasoline);
        deck.add(SpareTire); // 6x tires
        deck.add(SpareTire);
        deck.add(EndOfLimit); // 6x EOL
        deck.add(EndOfLimit);
        
        for (int i = 0; i < 3; i++) 
        {
            deck.add(Accident); // 3 x Accident
            deck.add(OutOfGas); // 3x out of gas
            deck.add(FlatTire); // 3x flattire
            deck.add(Stop);
            deck.add(SpeedLimit);
        }
        deck.add(Stop);
        deck.add(SpeedLimit); // 4x speedlimit
        deck.add(Stop); // 5x Stop
        
        //Safeties
        deck.add(RightOfWay);
        deck.add(FuelTank);
        deck.add(PunctureProof);
        deck.add(DrivingAce);
        
     // To randomize deck i will add shuffle using random to make the deck 
     // different for each game, for now every game will start with the same
     // card for each player because the deck is not random yet and players draw
     // from this deck
    }
    
    
    
    // create a random shuffle function
    public void shuffle()
    {
        Random randomInt = new Random();
        for (int i = 0; i < 106 ; i++) // we have 106 cards in a full deck so swap them
        {
            Collections.swap(deck,randomInt.nextInt(deck.size()),randomInt.nextInt(deck.size())); 
        }
    }
    
    public void removedeck()
    {
            deck.clear();
    }
    
    
    // Players from both side draw 6 cards to start the game
    public void First6Cards() {
        for (int i = 0; i < 6; i++) {
            Player1.AddCard(deck.remove(0));
            Player2.AddCard(deck.remove(0));
        }
    }
    
    // Draw Card for player 1
    public void P1DrawsCard() 
    {
        if (deck.isEmpty())
        {
            System.out.println("No more card to draw !");
        }
        else
        Player1.AddCard(deck.remove(0));
    }
    
     // Draw Card for player 2
    public void P2DrawsCard() 
    {
        if (deck.isEmpty())
        {
            System.out.println("No more card to draw !");
        }
        else
        Player2.AddCard(deck.remove(0));
    }
     
     
     // Function for player to discard from hand to deck
     public void discardfromhand(int player, int index)
     {
         if (player == 1)
         {
             if (Player1.HandSize()<= 0)
            {System.out.println("P1 has no more card to discard!");}
             else
                 discard_deck.add(Player1.UseCard(index));
             
         }
         else if (player == 2)
         {
             if (Player2.HandSize()<= 0)
         {System.out.println("P2 has no more card to discard!");}
             else
                 discard_deck.add(Player2.UseCard(index));
             
         }
     
     }
     
     public boolean isLegalMove(int player, int index) 
    {
        if (player == 1)
        {
        Card c = Player1.getCard(index);
        int distance;
        switch(c.cardname)
        {
            case "D25":
            case "D50":
            case "D75":
            case "D100":
            case "D200":
                distance = c.GetType();
                break;
            case "Accident":
            case "OutOfGas":
            case "FlatTire":
            case "Stop":
            case "SpeedLimit":
                return P2TAB.isValid(c); // we play this to the oponent field
            default:
                return P1TAB.isValid(c);
                
        }
        if (Player1.kilometers + distance > MaxKm)
            return false;
        
        return P1TAB.isValid(c);   
        }
        if (player == 2)
        {
        Card c = Player2.getCard(index);
        int distance;
        switch(c.cardname)
        {
            case "D25":
            case "D50":
            case "D75":
            case "D100":
            case "D200":
                distance = c.GetType();
                break;
            case "Accident":
            case "OutOfGas":
            case "FlatTire":
            case "Stop":
            case "SpeedLimit":
                return P1TAB.isValid(c); // again we play this to the oponent field
            default:
                return P2TAB.isValid(c);
                
        }
        if (Player2.kilometers + distance > MaxKm)
            return false;
        
        return P2TAB.isValid(c);   
        }
        else
            return false;
    }
    
     // try to actually move and use isLegalMove from above
    public int TryMove(int player, int index)
    {
        if (!isLegalMove(player, index))
        {
            System.out.println("Invalid move please try again !");
            return 0;
        }
        
        if (player == 1)
        {
        Card c = Player1.getCard(index);
        
        switch(c.cardname)
        {
            case "D25":
            case "D50":
            case "D75":
            case "D100":
                Player1.kilometers += c.GetType();
                Player1.TotalScore += c.GetType();
                P1TAB.playCard(c);
                break;
            case "D200":
                Player1.kilometers += c.GetType();
                Player1.TotalScore += c.GetType();
                Player1.play200 += 1;
                P1TAB.playCard(c);
                break;
                
            case "Accident":
            case "OutOfGas":
            case "FlatTire":
            case "Stop":
            case "SpeedLimit":
                P2TAB.playCard(c); //we play this to the oponent field
                break;
                
            case "RightOfWay":
            case "FuelTank":
            case "PunctureProof":
            case "DrivingAce":
                Player1.TotalScore += 100; // each safety
                P1TAB.playCard(c);
                P1DrawsCard();
                break;
                
            default:
                P1TAB.playCard(c); 
        }
        Player1.UseCard(index);
        return 0;
        }
        if (player == 2)
        {
        Card c = Player2.getCard(index);
        
        switch(c.cardname)
        {
            case "D25":
            case "D50":
            case "D75":
            case "D100":
                Player2.kilometers += c.GetType();
                Player2.TotalScore += c.GetType();
                P2TAB.playCard(c);
                break;
            case "D200":
                Player2.kilometers += c.GetType();
                Player2.TotalScore += c.GetType();
                Player2.play200 += 1;
                P2TAB.playCard(c);
                break;
            
            case "Accident":
            case "OutOfGas":
            case "FlatTire":
            case "Stop":
            case "SpeedLimit":
                P1TAB.playCard(c); //again we play this to the oponent field
                break;
                
            case "RightOfWay":
            case "FuelTank":
            case "PunctureProof":
            case "DrivingAce":
                Player2.TotalScore += 100; // each safety
                P2TAB.playCard(c);
                P2DrawsCard();
                break;
                
            default:
                P2TAB.playCard(c); 
        }
        Player2.UseCard(index);
        return 0;
        }
        else
            return 0;
    }
     
     
     
     
     // Determined if the game is over
     public int isGameOver()
     {
         int i = 0;
         int play200 = P1TAB.get200int();
         
         if (Player1.kilometers == MaxKm)
         {
             System.out.println("Game is over !");
             Player1.TotalScore += 400; // winner
             
             
             if (Player1.play200 == 0)
             {Player1.TotalScore += 300;} // safetrip
             
             if (Player2.kilometers == 0)
             {Player1.TotalScore += 500;} // shutout
             
             if(deck.isEmpty())
             {Player1.TotalScore += 300;} // Delayed
          
             CheckScore();
             return PLAYER1;
         }
         else
         if (Player2.kilometers == MaxKm)
         {
             System.out.println("Game is over !");
             
             Player2.TotalScore += 400; // winner
             
             if (Player2.play200 == 0)
             {Player2.TotalScore += 300;} // safetrip
             
             if (Player1.kilometers == 0)
             {Player2.TotalScore += 500;} // shutout
             
             if(deck.isEmpty())
             {Player2.TotalScore += 300;} // Delayed
             
             CheckScore();
             return PLAYER2;
          
             
         }
         else
         if (Player2.HandSize()<= 0 && Player1.HandSize() <= 0)
         {
             System.out.println("Game is over: No More Cards!");
             CheckScore();
         }
         else
         System.out.println("Game is not over");
         
        return i;
     }
     
      public void CheckScore()
      {
          int P1;
          int P2;
          P1 = Player1.TotalScore();
          P2 = Player2.TotalScore();
          
         
          
          if (P1 > P2)
          {
              System.out.println("Player 1 WON !");
          }
          if (P1 == P2)
          {
              System.out.println("Draw !");
          }
          if (P1 < P2)
          {
              System.out.println("Player 2 WON !");
          }
      }
     
     
     
     // Print discard deck to test if it works
     public void PrintDiscardDeck()
     {
         if (! discard_deck.isEmpty()) 
         {
            System.out.println("Discarded Cards:  ");
            for (int i = 0; i < discard_deck.size() ; i++) 
            {
            Card c = discard_deck.get(i);
            System.out.print(c);
            System.out.print("  ");
            }
            System.out.println();
         }
     }
     
     // Print hand of each players to show what cards they hold
     public void PrintHand(int p)
     {
       if (p==1)
       {
       System.out.print(Player1.GetName());
       System.out.println(" Hand: ");
       for (int i = 0; i < Player1.HandSize(); i++) 
        {
            System.out.print(Player1.getCard(i));
            System.out.print("  ");
        }
       System.out.println("!");
       
       System.out.print("Battle: ");
       System.out.print(P1TAB.GetBattleCard());
       
       System.out.print("       Speed: ");
       System.out.print(P1TAB.GetSpeedCard());
       
       System.out.print("       Safety: ");
       P1TAB.PrintSafety();
       
       }
       else if (p==2)
       {
       System.out.print(Player2.GetName());
       System.out.println(" Hand: ");
       for (int i = 0; i < Player2.HandSize(); i++) 
        {
            System.out.print(Player2.getCard(i));
            System.out.print("  ");
        }
       System.out.println("!");
       
       System.out.print("Battle: ");
       System.out.print(P2TAB.GetBattleCard());
       System.out.print("       Speed: ");
       
       System.out.print(P2TAB.GetSpeedCard());
       
       System.out.print("       Safety: ");
       P2TAB.PrintSafety();
       }
           
     }
     
     // Print score to keep track of each player
     public void PrintScore(int p)
     {
       if (p == 1)
       {
       System.out.print(Player1.GetName());
       System.out.print(" Score: ");
       System.out.println(Player1.GetScore());
       }
       if (p == 2)
       {
       System.out.print(Player2.GetName());
       System.out.print(" Score: ");
       System.out.println(Player2.GetScore());
       }
     }
     
       public void PrintAllScore()
     {
       System.out.print(Player1.GetName());
       System.out.print(" Score: ");
       System.out.println(Player1.GetScore());
     
       System.out.print(Player2.GetName());
       System.out.print(" Score: ");
       System.out.println(Player2.GetScore());
     }
       
         public void PrintTotalScore()
     {
       System.out.print(Player1.GetName());
       System.out.print(" Total Score: ");
       System.out.println(Player1.TotalScore);
     
       System.out.print(Player2.GetName());
       System.out.print(" Total Score: ");
       System.out.println(Player2.TotalScore);
     }

    void deck() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
           
     }
    
    
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedata;

import java.util.ArrayList;

/**
 *
 * @author Vinh
 */
class PlayerTable 
{
    // for now we only need BattleArea and DistanceArea to work
    // because we only testing Go Card and Distance Card
    private ArrayList<Card> DistanceArea;
    private ArrayList<Card> BattleArea;
    private ArrayList<Card> SpeedArea;
    private ArrayList<Card> SafetyArea;
    
    public int play200km;
    
    public PlayerTable()
    {
        DistanceArea = new ArrayList<>();
        BattleArea = new ArrayList<>();
        SpeedArea = new ArrayList<>();
        SafetyArea = new ArrayList<>();
        play200km = 0;
    }
    
    public void playCard(Card v)
    {
        if (!isValid(v))
        {
            System.out.println("This is an Invalid Move try again! ");
            
        }
        else 
        
        switch(v.cardname)
        {
            case "D25":
            case "D50":
            case "D75":
            case "D100":
                MoveToDistance(v);
            case "D200":
                play200km += 1;
                MoveToDistance(v);
                break;
                
            case "Go":
            case "Repair":
            case "Gasoline":
            case "SpareTire":
                MoveToBattle(v);
                break;
            
            case "Accident":
            case "OutOfGas":
            case "FlatTire":
            case "Stop":
                MoveToBattle(v);
                break;
                
            case "SpeedLimit":
            case "EndOfLimit":
                MoveToSpeed(v);
                break;
                
            case "DrivingAce":
            case "FuelTank":
            case "PunctureProof":
            case "RightOfWay":
                MoveToSafety(v);
                break;
        }
    }
    // Check if there is a Go card in BattleArea to see if it is a go
    // For now we only need to check this only later there are more things 
    // to check
    public boolean isGo()
    {
        Card BattleCard;
        if (! BattleArea.isEmpty())
            BattleCard = BattleArea.get(BattleArea.size() - 1);
        else
            return false;
        
        switch (BattleCard.cardname) 
        {
            case "Go":
                return true;
                
            case "Accident":
                for (Card c : SafetyArea)
                    if ("DrivingAce".equals(c.cardname))
                        return true;
                return false;
                
            case "OutOfGas":
                for (Card c : SafetyArea)
                    if ("FuelTank".equals(c.cardname))
                        return true;
                return false;
                
            case "FlatTire":
                for (Card c : SafetyArea)
                    if ("PunctureProof".equals(c.cardname))
                        return true;
                return false;
                
            case "Stop":
                for (Card c : SafetyArea)
                    if ("RightOfWay".equals(c.cardname))
                        return true;
                return false;
                
            case "Repair":
            case "Gasoline":
            case "SpareTire":
                for (Card c : SafetyArea)
                    if ("RightOfWay".equals(c.cardname))
                        return true;
                return false;
            
                
            default:
                return false;
        }
        
    }
    
    // check if valid to move card to different area
    public boolean isValid(Card v)
    {
        Card BattleCard; // check for last battle card in table
        if (! BattleArea.isEmpty())
            BattleCard = BattleArea.get(BattleArea.size() - 1);
        else
            BattleCard = new Card("Unknown");
        
        Card SpeedCard; // check for last speed card in table
        if (! SpeedArea.isEmpty())
            SpeedCard = SpeedArea.get(SpeedArea.size() - 1);
        else
            SpeedCard = new Card("Unknown");
        
        boolean playable = true;
        boolean isSpeedLimit = true;
            for (Card c : SafetyArea)
            {
                if ("RightOfWay".equals(c.cardname))
                    isSpeedLimit = false;
            }
        isSpeedLimit = (isSpeedLimit && SpeedCard.cardname == "SpeedLimit");
        
        
        switch(v.cardname)
        {
            case "D25":
            case "D50":
                return isGo(); // no need to check for speedlimit
            case "D75":
            case "D100":
                return (isGo() && !isSpeedLimit);
            case "D200": // can't play more than 2 times a hand
                if (isGo() && !isSpeedLimit && play200km < 2)
                {
                    return true;
                }
                else return false;
                
            case "Go":
                 switch(BattleCard.cardname)
                 {
                     case"Repair":
                     case"Gasoline":
                     case"SpareTire":
                     case"Stop":
                     case"Unknown":
                         return true; // can play go card after remedies or empty field
                     case"Accident":
                     case"OutOfGas":
                     case"FlatTire":
                         return false; // can't play go card need fixes
                     default:
                         return false;
                 }
            case "Accident":
                for (Card c : SafetyArea)
                    if ("DrivingAce".equals(c.cardname))
                        playable = false;
                return (playable && isGo()); // can't add more than 1 hazzard or has safety 
            case "OutOfGas":
                for (Card c : SafetyArea)
                    if ("FuelTank".equals(c.cardname))
                        playable = false;
                return (playable && isGo()); // can't add more than 1 hazzard or has safety 
            case "FlatTire":
                for (Card c : SafetyArea)
                    if ("PunctureProof".equals(c.cardname))
                        playable = false;
                return (playable && isGo()); // can't add more than 1 hazzard or has safety 
            case "Stop":
                for (Card c : SafetyArea)
                    if ("RightOfWay".equals(c.cardname))
                        playable = false;
                return (playable && isGo()); // can't add more than 1 hazzard or has safety 
            
            case "SpeedLimit": 
                for (Card c : SafetyArea)
                    if ("RightOfWay".equals(c.cardname))
                        playable = false;
                return (playable && SpeedCard.cardname != "SpeedLimit"); // can't add more than 1 hazzard or has safety 
                
                
            case "EndOfLimit":
                for (Card c : SafetyArea)
                    if ("RightOfWay".equals(c.cardname))
                        playable = false;
                return (playable && SpeedCard.cardname == "SpeedLimit"); // can't remedy speed if already has remedy or safety 
                
            case "Repair":
                for (Card c : SafetyArea)
                    if ("DrivingAce".equals(c.cardname))
                        playable = false;
                return (playable && BattleCard.cardname == "Accident"); // can't remedy if already has remedy or safety 
                
            case "Gasoline": 
                for (Card c : SafetyArea)
                    if ("FuelTank".equals(c.cardname))
                        playable = false;
                return (playable && BattleCard.cardname == "OutOfGas"); // can't remedy if already has remedy or safety 
                
            case "SpareTire":    
                for (Card c : SafetyArea)
                    if ("PunctureProof".equals(c.cardname))
                        playable = false;
                return (playable && BattleCard.cardname == "FlatTire"); // can't remedy  if already has remedy or safety 
            
            case "DrivingAce":
            case "FuelTank":
            case "PunctureProof":
            case "RightOfWay":   
                return true;
                
            default:
                return false;
                    
        }  
    }
    
    public void PrintSafety()
    {
        
        for (int i = 0; i < SafetyArea.size() ; i++) 
        {
            Card c = SafetyArea.get(i);
            System.out.print(c);
            System.out.print("  ");
        }
        System.out.println();
        
        
        
    }
    
    public Card GetBattleCard()
    {
        Card BattleCard; // check for last battle card in table
        if (! BattleArea.isEmpty())
            BattleCard = BattleArea.get(BattleArea.size() - 1);
        else
            BattleCard = new Card("Unknown");
        
        return BattleCard;
        
    }
    
     public Card GetSpeedCard()
    {
        Card SpeedCard; // check for last battle card in table
        if (! SpeedArea.isEmpty())
            SpeedCard = SpeedArea.get(SpeedArea.size() - 1);
        else
            SpeedCard = new Card("Unknown");
        
        return SpeedCard;
        
    }

    //add to distance area
    private void MoveToDistance(Card v) 
    {
        DistanceArea.add(v);
    }
     //add to battle area
    private void MoveToBattle(Card v )
    {
        BattleArea.add(v);
    }

    private void MoveToSpeed(Card v) 
    {
        SpeedArea.add(v);
    }

    private void MoveToSafety(Card v) {
        SafetyArea.add(v);
    }
    public int get200int() {
        return play200km;
    }
}

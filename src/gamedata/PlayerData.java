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
public class PlayerData 
{
    protected String name;
    protected int kilometers;
    protected int TotalScore;
    protected int play200;
    private ArrayList<Card> playerhand;
    
// Constructor that make player with no name and assign km traveled score start at 0
public PlayerData (String n) 
{
    name = n;
    kilometers = 0;
    TotalScore = 0;
    play200 = 0;
    playerhand = new ArrayList<>();
    
}
public String GetName ()
{
    return name;
}

public int GetScore ()
{
    return kilometers;
}

public int TotalScore ()
{
    return TotalScore;
}


// Need to add card from deck in the beginning of each player turn
public void AddCard (Card cardfromdeck)
{
    playerhand.add(cardfromdeck);
}

public Card UseCard(int i) 
{
    return playerhand.remove(i);
}

public Card getCard(int i) 
{
    return playerhand.get(i);
}

public int HandSize() 
{
        return playerhand.size();
}

}

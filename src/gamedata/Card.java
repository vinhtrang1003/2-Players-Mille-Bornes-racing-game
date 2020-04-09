/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedata;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinh
 */
public class Card 
{
    
public String cardname;
public int type;

    
public Card (String cname)
{
    cardname = cname;
}

public int GetType ()
{
  type = GetType();
  return type;
}

@Override
public String toString() 
{
return cardname;
}
}




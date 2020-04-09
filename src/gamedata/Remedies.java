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
public class Remedies extends Card 
{
  
  public int remtype = 0; 
  // Go             =  1
  // Repair         =  2
  // Gasoline       =  3
  // SpareTire      =  4
  // EndOfLimit     =  5
  
  

    public Remedies(String cname, 
                    int rt) 
    {
        super(cname);
        remtype = rt;
    }
    
    @Override
    public int GetType() 
    {
        return remtype;
    }

    
}

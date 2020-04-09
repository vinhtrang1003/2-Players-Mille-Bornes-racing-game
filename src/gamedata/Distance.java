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
public class Distance extends Card 
{
    // adding value to Distance that extends from Card class
    public int kmvalue;

    public Distance(String cname, 
                    int km) 
    {
        super(cname);
        kmvalue = km;
    }
    
    @Override
    public int GetType() 
    {
        return kmvalue;
    }


    
}

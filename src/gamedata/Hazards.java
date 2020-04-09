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
public class Hazards extends Card 
{
    
    public int HaType = 0;
    // incoming features
    //Accident      = 1
    //OutOfGas      = 2
    //FlatTire      = 3
    //Stop          = 4
    //SpeedLimit    = 5

    public Hazards(String cname,
                    int ht) 
    {
        super(cname);
        HaType = ht;
    }
    
    @Override
    public int GetType() 
    {
        return HaType;
    }


    
}

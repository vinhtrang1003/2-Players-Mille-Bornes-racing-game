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
public class Safeties extends Card 
{
    public int SaType = 0;
    // DrivingAce     =  1
    // FuelTank       =  2
    // PunctureProof  =  3
    // RightOfWay     =  4


    public Safeties(String cname,
                    int st) 
    {
        super(cname);
        SaType = st;
    }
    
    @Override
    public int GetType() 
    {
        return SaType;
    }

}

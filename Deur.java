
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Deur here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Deur extends Mover
{
    int Ster = 0;
    /*public Deur(int ster)
    {
        this.Ster = ster;
    }
    /**
     * Act - do whatever the Deur wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        applyVelocity();
        if(getOneIntersectingObject(Hero.class)!= null && getWorld().getObjects(YellowKey.class).isEmpty()&& (Ster == 2))
        {
            
            
                    Greenfoot.setWorld(new LevelSelect());
                
        }
    }    
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ster extends Mover
{
    
    /**
     * Act - do whatever the Ster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int Ster = 0;
        for (Actor enemy : getIntersectingObjects(Hero.class))
        {
            if (enemy != null)
            {
               
                getWorld().removeObject(this);
                Ster++;
                
                break;
                
            }
        }
       
        applyVelocity();
         
        
  

}
}   


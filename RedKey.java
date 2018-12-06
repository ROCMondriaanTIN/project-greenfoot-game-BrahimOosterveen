import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedKey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedKey extends Mover
{
    /**
     * Act - do whatever the Greenkey wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
             for (Actor Red : getIntersectingObjects(Hero.class)){
          if (Red != null) {
              getWorld().removeObject(this);
              break;
    }    
   }
   applyVelocity();
    }    
}

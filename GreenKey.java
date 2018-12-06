import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Greenkey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GreenKey extends Mover
{
    /**
     * Act - do whatever the Greenkey wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
             for (Actor Green : getIntersectingObjects(Hero.class)){
          if (Green != null) {
              getWorld().removeObject(this);
              break;
    }    
   }
   applyVelocity();
    }    
}

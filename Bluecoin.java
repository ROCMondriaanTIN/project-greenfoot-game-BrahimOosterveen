import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bluecoin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bluecoin extends Mover
{
    /**
     * Act - do whatever the Bluecoin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
                      for (Actor Bluecoin : getIntersectingObjects(Hero.class)){
          if (Bluecoin != null) {
              getWorld().removeObject(this);
              break;
       }    
      }
       applyVelocity();
    }    
}

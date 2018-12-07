import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Diamand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Diamand extends Mover
{
    /**
     * Act - do whatever the Diamand wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
             /*for (Actor Diamand : getIntersectingObjects(Hero.class)){
          if (Diamand != null) {
              getWorld().removeObject(this);
              break;
    }    
   }*/
   applyVelocity();
    }    
}

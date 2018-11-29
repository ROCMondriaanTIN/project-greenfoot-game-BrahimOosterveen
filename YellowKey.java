import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class YellowKey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YellowKey extends Mover
{
   private boolean YellowKey = false;
    /**
     * Act - do whatever the YellowKey wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   public void act() 
    {
      for (Actor Yellow : getIntersectingObjects(Hero.class)){
          if (Yellow != null) {
              getWorld().removeObject(this);
              break;
    }    
   }
   applyVelocity();
 }
}

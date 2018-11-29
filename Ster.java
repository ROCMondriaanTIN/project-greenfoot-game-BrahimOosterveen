
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ster here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ster extends Mover {
    private int ster = 1;
    /**
     * Act - do whatever the Ster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
      for (Actor hero : getIntersectingObjects(Hero.class)){
          if (hero != null) {
              Hero h = (Hero)hero;
              h.Sterrenteller(ster);
              getWorld().removeObject(this);
             
       }    
      }
        applyVelocity();
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pinkcoin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pinkcoin extends Mover
{
    /**
     * Act - do whatever the Pinkcoin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
                     for (Actor Pinkcoin : getIntersectingObjects(Hero.class)){
          if (Pinkcoin != null) {
              getWorld().removeObject(this);
              break;
    }    
   }
   applyVelocity();
    }    
    }    


import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Greencoin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Greencoin extends Mover
{
    /**
     * Act - do whatever the Greencoin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
                     for (Actor Greencoin : getIntersectingObjects(Hero.class)){
          if (Greencoin != null) {
              getWorld().removeObject(this);
              break;
    }    
   }
   applyVelocity();
    }    
    }    


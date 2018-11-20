import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Yes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Yes extends Button
{
    int level;
    
    Yes(int level)
    {
        this.level = level;
    }
    /**
    
       * Act - do whatever the Yes wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(level == 1){
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new MyWorld());
            //if (Greenfoot.isKeyDown("space")) Greenfoot.setWorld(new LevelSelect());
        }
    }
    else if (level == 2){
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Lvl2());
            //if (Greenfoot.isKeyDown("space")) Greenfoot.setWorld(new LevelSelect());
        }
    }
    }    
}
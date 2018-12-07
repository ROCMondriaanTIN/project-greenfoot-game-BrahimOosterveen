import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Reset here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reset extends Mover
{
    int lvl;
    public Reset(int lvl){
        this.lvl = lvl;
    }
    /**
     * Act - do whatever the Reset wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(lvl ==  1){
            if (Greenfoot.mouseClicked(this))
            {
                Greenfoot.setWorld(new MyWorld());
            }
        }
        else if(lvl == 2)
        {
            if (Greenfoot.mouseClicked(this))
            {
                Greenfoot.setWorld(new Lvl2());
            }
        }
    }    
}

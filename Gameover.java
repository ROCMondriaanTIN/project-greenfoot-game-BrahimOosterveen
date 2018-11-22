import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gameover here.
 * 
 * @author (Brahim Oosterveen) 
 * @version (22-11-2018)
 */
public class Gameover extends World
{
     int level;
    public Gameover(int lvl)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        level = lvl;
        prepare();
    }

    private void prepare()
    {
        No no = new No();
        addObject(no,561,580);
        Yes yes = new Yes(level);
        addObject(yes,454,581);
    }
}


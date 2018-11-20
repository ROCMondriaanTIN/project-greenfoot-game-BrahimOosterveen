import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gameover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gameover extends World
{

    int level;
    /**
     * Constructor for objects of class Gameover.
     * 
     */
    public Gameover(int lvl)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        level = lvl;
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        No no = new No();
        addObject(no,561,580);
        Yes yes = new Yes(level);
        addObject(yes,454,581);
    }
}


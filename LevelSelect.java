import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelSelect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelSelect extends World
{

    public LevelSelect()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1300, 800, 1); 

        prepare();
    }

    public void act()
    {
        if (Greenfoot.isKeyDown("1")) {
                Greenfoot.setWorld(new MyWorld()); 
        }
    }
    
    private void prepare()
    {
        Level1 level1 = new Level1();
        addObject(level1,335,464);
        Level2 level2 = new Level2();
        addObject(level2,542,464);
    }
}

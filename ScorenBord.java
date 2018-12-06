import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScorenBord here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScorenBord extends Mover
{
    public boolean Greenkey = false;
    public boolean Bluekey = false;
    public boolean RedKey = false;
    public boolean YellowKey = false;
    public int ster = 1;
    public boolean diamand = false;
    /**
     * Act - do whatever the ScorenBord wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
   
    public void act() {
        
    }
    
    public void BlueKeyHud() {
        Bluekey = true;
        getWorld().addObject(new BlueKeyHud(), 50, 750);
    }
    public void GreenKeyHud() {
        Greenkey = true;
        getWorld().addObject(new GreenKeyHud(), 100, 750);
    }
        public void RedKeyHud() {
        RedKey = true;
        getWorld().addObject(new RedKeyHud(), 150, 750);
    }
        public void YellowKeyHud() {
        YellowKey = true;
        getWorld().addObject(new YellowKeyHud(), 200, 750);
    }
    
    public void DiamandHud() {
        diamand = true;
        getWorld().addObject(new DiamandHud(), 900, 750);
    }
    
 
    
    public void SterHud() {
        switch (ster) {
            case 1:
                ster++;
                getWorld().addObject(new SterHud(), 820,100);
                break;
            case 2:
                ster++;
                getWorld().addObject(new SterHud(), 890, 100);
                break;
            case 3:
                ster++;
                getWorld().addObject(new SterHud(), 960, 100);
                break;
            default:
                ster = 0;
    }    
}
}

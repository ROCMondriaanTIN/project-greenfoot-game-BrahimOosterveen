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
    public boolean Redkey = false;
    public boolean Yellowkey = false;
    public int ster = 1;
    public boolean diamant = false;
    /**
     * Act - do whatever the ScorenBord wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
   
    public void act() {
        
    }
    
    public void BlueKeyHud() {
        Bluekey = true;
        getWorld().addObject(new BlueKeyHud(), 400, 1000);
    }
    public void GreenKeyHud() {
        Greenkey = true;
        getWorld().addObject(new GreenKeyHud(), 100, 200);
    }
        public void RedKeyHud() {
        Greenkey = true;
        getWorld().addObject(new RedKeyHud(), 100,300);
    }
        public void YellowKeyHud() {
        Greenkey = true;
        getWorld().addObject(new YellowKeyHud(), 100, 400);
    }
    
    public void DiamandHud() {
        diamant = true;
        getWorld().addObject(new DiamandHud(), 100, 500);
    }
    
   /* public void SterHud() {
        switch (ster) {
            case 1:
                ster++;
                getWorld().addObject(new SterHud(false), 100,600);
                break;
            case 2:
                ster++;
                getWorld().addObject(new SterHud(false), 100, 700);
                break;
            case 3:
                ster++;
                getWorld().addObject(new SterHud(true), 100, 800);
                break;
            default:
                ster = 0;
    }    
}*/
}

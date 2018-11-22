
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    
    private final GreenfootImage RMidle= new GreenfootImage("p123.png");
    private final GreenfootImage RMjump= new GreenfootImage("p1_jump.png");
    private final GreenfootImage RMwalk1= new GreenfootImage("p1_walk01.png");
    private final GreenfootImage RMwalk2= new GreenfootImage("p1_walk02.png");
    private final GreenfootImage RMwalk3= new GreenfootImage("p1_walk03.png");
    private final GreenfootImage RMwalk4= new GreenfootImage("p1_walk04.png");
    private final GreenfootImage RMwalk5= new GreenfootImage("p1_walk05.png");
    private final GreenfootImage RMwalk6= new GreenfootImage("p1_walk06.png");
    private final GreenfootImage RMwalk7= new GreenfootImage("p1_walk07.png");
    private final GreenfootImage RMwalk8= new GreenfootImage("p1_walk08.png");
    private final GreenfootImage RMwalk9= new GreenfootImage("p1_walk09.png");
    private final GreenfootImage RMwalk10= new GreenfootImage("p1_walk10.png");
    private final GreenfootImage RMwalk11= new GreenfootImage("p1_walk11.png");
 
    private final GreenfootImage LMidle = new GreenfootImage("p1inv.png");
    private final GreenfootImage LMjump = new GreenfootImage(RMjump);
    private final GreenfootImage LMwalk1 = new GreenfootImage("p1inv_walk01.png");
    private final GreenfootImage LMwalk2 = new GreenfootImage("p1inv_walk02.png");
    private final GreenfootImage LMwalk3 = new GreenfootImage("p1inv_walk03.png");
    private final GreenfootImage LMwalk4 = new GreenfootImage("p1inv_walk04.png");
    private final GreenfootImage LMwalk5 = new GreenfootImage("p1inv_walk05.png");
    private final GreenfootImage LMwalk6 = new GreenfootImage("p1inv_walk06.png");
    private final GreenfootImage LMwalk7 = new GreenfootImage("p1inv_walk07.png");
    private final GreenfootImage LMwalk8 = new GreenfootImage("p1inv_walk08.png");
    private final GreenfootImage LMwalk9 = new GreenfootImage("p1inv_walk09.png");
    private final GreenfootImage LMwalk10 = new GreenfootImage("p1inv_walk10.png");
    private final GreenfootImage LMwalk11 = new GreenfootImage("p1inv_walk01.png");
    int level;
    private int speed = 3;
    private int frame;
    private boolean lopen;
    private boolean Kijkenrechts;
    private boolean isKeyPressed;
    private boolean touchedKey = false;
    private boolean YellowKey = false;
    public int Ster = 0;
    

    
    public Hero(int level) {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p123.png");
        this.level = level;
        setImage(RMidle);
        lopen = false;
        Kijkenrechts = true;
 
        RMidle.scale(70,100);
        RMjump.scale(70,100);
        RMwalk1.scale(70,100);
        RMwalk2.scale(70,100);
        RMwalk3.scale(70,100);
        RMwalk4.scale(70,100);
        RMwalk5.scale(70,100);
        RMwalk6.scale(70,100);
        RMwalk7.scale(70,100);
        RMwalk8.scale(70,100);
        RMwalk9.scale(70,100);
        RMwalk10.scale(70,100);
        RMwalk11.scale(70,100);
 
        LMidle.scale(70,100);
        LMjump.scale(70,100);
        LMwalk1.scale(70,100);
        LMwalk2.scale(70,100);
        LMwalk3.scale(70,100);
        LMwalk4.scale(70,100);
        LMwalk5.scale(70,100);
        LMwalk6.scale(70,100);
        LMwalk7.scale(70,100);
        LMwalk8.scale(70,100);
        LMwalk9.scale(70,100);
        LMwalk10.scale(70,100);
        LMwalk11.scale(70,100);
        
    }

    @Override
    public void act() {
        handleInput();
        
        checkKeys();
        onGround();
        
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();
        //slotKey();
        //removeLock();

        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                Greenfoot.setWorld(new Gameover(level));
                break;
            }
        }
        
        for (Actor liquidWater : getIntersectingObjects(TileExtended.class)) {
            TileExtended tile = (TileExtended) liquidWater;
            if (tile != null && tile.type == "water") {
                Greenfoot.setWorld(new Gameover(level));
                break;
            }
        }
        
        {
        if (!touchedKey)
        touchedKey = getOneIntersectingObject(YellowKey.class) != null;
        if (getOneIntersectingObject(Deur.class) != null && touchedKey)
         Greenfoot.setWorld(new LevelSelect());
        }

    }
     
 
    public void checkKeys()
    {
        isKeyPressed = false;
        if (Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("a"))
        {
            stoplopen();
            isKeyPressed = true;
        }
        else if (Greenfoot.isKeyDown("d"))
        {
            walkRight();
            setLocation (getX()+speed, getY());
            isKeyPressed = true;
        }
        else if (Greenfoot.isKeyDown("a"))
        {
            walkLeft();
            setLocation (getX()-speed, getY());
            isKeyPressed = true;
        }
        if (!(isKeyPressed))
        {
            stoplopen();
        }
    }
    
    
    public boolean onGround()
    {
        Actor under = getOneObjectAtOffset (0, getHeight ()/2, Tile.class);
        Tile tile = (Tile) under;
        return tile != null && tile.isSolid == true; 
    }
    
    
    public void handleInput() {
        if (Greenfoot.isKeyDown("space") && onGround() == true) {
            velocityY = -15;
        }
        if (Greenfoot.isKeyDown("a")) {
            velocityX = -4;
        } else if (Greenfoot.isKeyDown("d")) {
            velocityX = 4;
        }
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
 
    public void walkRight()
    {
        lopen = true;
        Kijkenrechts = true;
        frame ++;
        if(frame==1)
        {
            setImage(RMidle);
        }
        else if(frame==2)
        {
            setImage(RMwalk1);
        }
        else if(frame==3)
        {
            setImage(RMwalk2);
        }
        else if(frame==4)
        {
            setImage(RMwalk3);
        }
        else if(frame==5)
        {
            setImage(RMwalk4);
        }
        else if(frame==6)
        {
            setImage(RMwalk5);
        }
        else if(frame==7)
        {
            setImage(RMwalk6);
        }
        else if(frame==8)
        {
            setImage(RMwalk7);
        }
        else if(frame==9)
        {
            setImage(RMwalk8);
        }
        else if(frame==10)
        {
            setImage(RMwalk9);
        }
        else if(frame==11)
        {
            setImage(RMwalk10);
        }
        else if (frame==12){
            setImage(RMwalk11);
            frame = 1;
            return;
        }
    }
    
    public void walkLeft()
    {
        lopen = true;
        Kijkenrechts = false;
        frame ++;
        if(frame==1)
        {
            setImage(LMidle);
        }
        else if(frame==2)
        {
            setImage(LMwalk1);
        }
        else if(frame==3)
        {
            setImage(LMwalk2);
        }
        else if(frame==4)
        {
            setImage(LMwalk3);
        }
        else if(frame==5)
        {
            setImage(LMwalk4);
        }
       else if(frame==6)
        {
            setImage(LMwalk5);
        }
        else if(frame==7)
        {
            setImage(LMwalk6);
        }
        else if(frame==8)
        {
            setImage(LMwalk7);
        }
        else if(frame==9)
        {
            setImage(LMwalk8);
        }
        else if(frame==10)
        {
            setImage(LMwalk9);
        }
        else if(frame==11)
        {
            setImage(LMwalk10);
        }
        else if (frame==12)
        {
            setImage(LMwalk11);
            frame = 1;
            return;
        }
    }
 
    public void stoplopen()
    {
        lopen = false;
        if (Kijkenrechts)
            setImage (RMidle);
        else
            setImage (LMidle);
     }
     
    public void Deur()
      {
          for (Actor deur : getIntersectingObjects(Deur.class))
          {
              if((YellowKey==true)  && (Ster>=2));
              {
                  if(Deur.class != null){
                      
                      {
                       Greenfoot.setWorld(new Lvl2());
                       String actieveWereld = "Level2";
                       return;
                      }
                }
        }
      }
    }
}
    /*public boolean slotKey()
    {
        Actor Key = getOneIntersectingObjects(Key.class);
        if(isTouching(Key.class))
        {
            removeTouching(Key.class);
            Key = true;
        }
        return Key;
    }
}
        
    */





import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;

    /*private final GreenfootImage RMidle = new GreenfootImage("p123.png");
    private final GreenfootImage RMjump = new GreenfootImage("p1_jump.png");
    private final GreenfootImage RMwalk1 = new GreenfootImage("p1_walk01.png");
    private final GreenfootImage RMwalk2 = new GreenfootImage("p1_walk02.png");
    private final GreenfootImage RMwalk3 = new GreenfootImage("p1_walk03.png");
    private final GreenfootImage RMwalk4 = new GreenfootImage("p1_walk04.png");
    private final GreenfootImage RMwalk5 = new GreenfootImage("p1_walk05.png");
    private final GreenfootImage RMwalk6 = new GreenfootImage("p1_walk06.png");
    private final GreenfootImage RMwalk7 = new GreenfootImage("p1_walk07.png");
    private final GreenfootImage RMwalk8 = new GreenfootImage("p1_walk08.png");
    private final GreenfootImage RMwalk9 = new GreenfootImage("p1_walk09.png");
    private final GreenfootImage RMwalk10 = new GreenfootImage("p1_walk10.png");
    private final GreenfootImage RMwalk11 = new GreenfootImage("p1_walk11.png");

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
    private final GreenfootImage LMwalk11 = new GreenfootImage("p1inv_walk10.png");*/
    int level;
    private int speed = 3;
    private int frame;
    private boolean lopen;
    private boolean Kijkenrechts;
    private boolean isKeyPressed;
    private boolean touchedKey = false;
    private boolean YellowKey = false;
    private boolean Bluekey = false;
    private int blueCoin = 0;
    private int greenCoin = 0;
    private int pinkCoin = 0;
    public int Ster = 0;
    private int velocity = 0;
    int waardeCoin = 1;
    int sterren;
    
    

    public Hero(int level) {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p123.png");
        this.level = level;
        
        lopen = false;
        Kijkenrechts = true;

       /* RMidle.scale(70, 100);
        RMjump.scale(70, 100);
        RMwalk1.scale(70, 100);
        RMwalk2.scale(70, 100);
        RMwalk3.scale(70, 100);
        RMwalk4.scale(70, 100);
        RMwalk5.scale(70, 100);
        RMwalk6.scale(70, 100);
        RMwalk7.scale(70, 100);
        RMwalk8.scale(70, 100);
        RMwalk9.scale(70, 100);
        RMwalk10.scale(70, 100);
        RMwalk11.scale(70, 100);

        LMidle.scale(70, 100);
        LMjump.scale(70, 100);
        LMwalk1.scale(70, 100);
        LMwalk2.scale(70, 100);
        LMwalk3.scale(70, 100);
        LMwalk4.scale(70, 100);
        LMwalk5.scale(70, 100);
        LMwalk6.scale(70, 100);
        LMwalk7.scale(70, 100);
        LMwalk8.scale(70, 100);
        LMwalk9.scale(70, 100);
        LMwalk10.scale(70, 100);
        LMwalk11.scale(70, 100);*/

    }
    
    Scoren scoren;

    @Override
    public void act() {
        if(scoren == null) {
            scoren = new Scoren();
            getWorld().addObject(new Scoren(), -50, -50);
        }
        
        getSter();
        Deur();
        yellowKey();
        blueKey();
        Lock();
        handleInput();
        blueCoin();
        greenCoin();
        pinkCoin();

        checkKeys();
        onGround();
        //removeLock();
        

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

    }
    
    public void getSter() {
        if(isTouching(Ster.class)) {
            Ster ++;
            removeTouching(Ster.class);
        }
    }
    public void yellowKey() {
        if(isTouching(YellowKey.class)) {
            YellowKey = true;
            removeTouching(YellowKey.class);
        }
    }
    public void blueKey() {
        if(isTouching(Bluekey.class)) {
            Bluekey = true;
            removeTouching(Bluekey.class);
            
        }
    }
    
        public void blueCoin() {
        if(isTouching(Bluecoin.class)) {
            waardeCoin = 2;
            removeTouching(Bluecoin.class);
        }
    }
    
            public void greenCoin() {
        if(isTouching(Greencoin.class)) {
            waardeCoin = 1;
            removeTouching(Greencoin.class);
        }
    }
    
    public void pinkCoin() {
         if(isTouching(Pinkcoin.class)) {
            waardeCoin = 3;
            removeTouching(Pinkcoin.class);
         }
    }

    public void checkKeys() {
        isKeyPressed = false;
        if (Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("a")) {
            stoplopen();
            isKeyPressed = true;
        } else if (Greenfoot.isKeyDown("d")) {
            walkRight();
            setLocation(getX() + speed, getY());
            isKeyPressed = true;
        } else if (Greenfoot.isKeyDown("a")) {
            walkLeft();
            setLocation(getX() - speed, getY());
            isKeyPressed = true;
        }
        if (!(isKeyPressed)) {
            stoplopen();
        }
    }

    public boolean onGround() {
        Actor under = getOneObjectAtOffset(0, getHeight() / 2, Tile.class);
        Tile tile = (Tile) under;
        return tile != null && tile.isSolid == true;
    }

    public void handleInput() {
        if (Greenfoot.isKeyDown("w") && onGround() == true) {
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

    public void walkRight() {
        lopen = true;
        Kijkenrechts = true;
        frame++;
        if (frame == 1) {
            setImage("p123.png");
        } else if (frame == 2) {
            setImage("p"+waardeCoin+"_walk01.png");
        } else if (frame == 3) {
            setImage("p"+waardeCoin+"_walk02.png");
        } else if (frame == 4) {
            setImage("p"+waardeCoin+"_walk03.png");
        } else if (frame == 5) {
            setImage("p"+waardeCoin+"_walk04.png");
        } else if (frame == 6) {
            setImage("p"+waardeCoin+"_walk05.png");
        } else if (frame == 7) {
            setImage("p"+waardeCoin+"_walk06.png");
        } else if (frame == 8) {
            setImage("p"+waardeCoin+"_walk07.png");
       /* } else if (frame == 9) {
            setImage("p"+waardeCoin+"_walk08.png");
        } else if (frame == 10) {
            setImage("p"+waardeCoin+"_walk09.png");
        } else if (frame == 11) {
            setImage("p"+waardeCoin+"_walk10.png");
        } else if (frame == 12) {
            setImage("p"+waardeCoin+"_walk11.png");*/
            frame = 1;
            return;
        }
    }

    public void walkLeft() {
        lopen = true;
        Kijkenrechts = false;
        frame++;
        if (frame == 1) {
            setImage("p"+waardeCoin+"inv.png");
        } else if (frame == 2) {
            setImage("p"+waardeCoin+"inv_walk01.png");
        } else if (frame == 3) {
            setImage("p"+waardeCoin+"inv_walk02.png");
        } else if (frame == 4) {
            setImage("p"+waardeCoin+"inv_walk03.png");
        } else if (frame == 5) {
            setImage("p"+waardeCoin+"inv_walk04.png");
        } else if (frame == 6) {
            setImage("p"+waardeCoin+"inv_walk05.png");
        } else if (frame == 7) {
            setImage("p"+waardeCoin+"inv_walk06.png");
        } else if (frame == 8) {
            setImage("p"+waardeCoin+"inv_walk07.png");
      /*  } else if (frame == 9) {
            setImage("p"+waardeCoin+"inv_walk08.png");
        } else if (frame == 10) {
            setImage("p"+waardeCoin+"inv_walk09.png");
        } else if (frame == 11) {
            setImage("p"+waardeCoin+"inv_walk10.png");
        } else if (frame == 12) {
            setImage("p"+waardeCoin+"inv_walk10.png");*/
            frame = 1;
            return;
        }
    }

    public void stoplopen() {
        lopen = false;
        if (Kijkenrechts) {
            setImage("p"+waardeCoin+"_stand.png");
        } else {
            setImage("p"+waardeCoin+"_invstand.png");
        }
    
    /*public void Jumpani(){
       velocity = 0;
       if (Kijkenrechts) {
            setImage(RMjump);
        } else {
            setImage(LMjump);
       
     }*/
    }

    public void Deur() {
        if (isTouching(Deur.class) && YellowKey && Ster >= 2) {
            Greenfoot.setWorld(new Lvl2());
        }
    }
    public void Lock(){
    
           
           if (isTouching(Bluelock.class) && Bluekey) {
            removeTouching(Bluelock.class);
            //world.removeObject(this);
        }
        
    }
    
    public int Sterrenteller(int ster){
    sterren = sterren + ster;
    getWorld().showText("Sterren: " + sterren, 100, 100);
    return sterren;
}
}



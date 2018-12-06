
import greenfoot.*;
import java.util.List;
/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    int level;
    private int speed = 3;
    private int frame;
    private boolean lopen;
    private boolean Kijkenrechts;
    private boolean isKeyPressed;
    private boolean touchedKey = false;
    private boolean YellowKey = false;
    private boolean BlueKey = false;
    private boolean Redkey = false;
    private boolean GreenKey = false;
    private boolean Diamand = false;
    private int blueCoin = 0;
    private int greenCoin = 0;
    private int pinkCoin = 0;
    public int Ster = 0;
    private int velocity = 0;
    int waardeCoin = 1;
    int sterren;
    public boolean isSolid = true;
    ScorenBord sb;

    public Hero(int level) {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p123.png");
        this.level = level;

        lopen = false;
        Kijkenrechts = true;
    }

    @Override
    public void act() {
        if (sb == null) {
            sb = new ScorenBord();
            getWorld().addObject(sb, -10, -10);
        }

        getSter();
        Deur();
        yellowKey();
        blueKey();
        greenKey();
        redKey();
        diaMand();
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
    public void removelock()
        {
        for (Actor BlueLock : getIntersectingObjects(BlueLock.class)) 
            if (BlueLock != null && BlueKey) {
                
                getWorld().removeObject(BlueLock);
                break;

           }
    }     
         
      
    

    public void getSter() {
        if (isTouching(Ster.class)) {
            //if (Ster < 3);
            Ster++;
            removeTouching(Ster.class);
            sb.SterHud();
        }
    }

    public void yellowKey() {
        if (isTouching(YellowKey.class)) {
            YellowKey = true;
            removeTouching(YellowKey.class);
            sb.YellowKeyHud();
        }
    }

    public void blueKey() {
        if (isTouching(BlueKey.class)) {
            BlueKey = true;
            removeTouching(BlueKey.class);
            sb.BlueKeyHud();

        }
    }

    public void redKey() {
        if (isTouching(RedKey.class)) {
            Redkey = true;
            removeTouching(RedKey.class);
            sb.RedKeyHud();

        }
    }

    public void greenKey() {
        if (isTouching(GreenKey.class)) {
            GreenKey = true;
            removeTouching(GreenKey.class);
            sb.GreenKeyHud();

        }
    }
   public void diaMand() {
        if (isTouching(Diamand.class)) {
            Diamand = true;
            removeTouching(Diamand.class);
            sb.DiamandHud();

        }
    }

 
    public void blueCoin() {
        if (isTouching(Bluecoin.class)) {
            waardeCoin = 2;
            removeTouching(Bluecoin.class);
        }
    }

    public void greenCoin() {
        if (isTouching(Greencoin.class)) {
            waardeCoin = 1;
            removeTouching(Greencoin.class);
        }
    }

    public void pinkCoin() {
        if (isTouching(Pinkcoin.class)) {
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
            setImage("p" + waardeCoin + "_walk01.png");
        } else if (frame == 3) {
            setImage("p" + waardeCoin + "_walk02.png");
        } else if (frame == 4) {
            setImage("p" + waardeCoin + "_walk03.png");
        } else if (frame == 5) {
            setImage("p" + waardeCoin + "_walk04.png");
        } else if (frame == 6) {
            setImage("p" + waardeCoin + "_walk05.png");
        } else if (frame == 7) {
            setImage("p" + waardeCoin + "_walk06.png");
        } else if (frame == 8) {
            setImage("p" + waardeCoin + "_walk07.png");
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
            setImage("p" + waardeCoin + "inv.png");
        } else if (frame == 2) {
            setImage("p" + waardeCoin + "inv_walk01.png");
        } else if (frame == 3) {
            setImage("p" + waardeCoin + "inv_walk02.png");
        } else if (frame == 4) {
            setImage("p" + waardeCoin + "inv_walk03.png");
        } else if (frame == 5) {
            setImage("p" + waardeCoin + "inv_walk04.png");
        } else if (frame == 6) {
            setImage("p" + waardeCoin + "inv_walk05.png");
        } else if (frame == 7) {
            setImage("p" + waardeCoin + "inv_walk06.png");
        } else if (frame == 8) {
            setImage("p" + waardeCoin + "inv_walk07.png");
            /*  } else if (frame == 9) {
            setImage("p"+waardeCoin+"inv_walk08.png");
        } else if (frame == 10) {
            setImage("p"+waardeCoin+"inv_walk09.png");
        } else if (frame == 11) {
            setImage("p"+waardeCoin+"inv_walk10.png");
        } else if (frame == 12) {
            setImage("p"+waardeCoin+"inv_walk11.png");*/
            frame = 1;
            return;
        }
    }

    public void stoplopen() {
        lopen = false;
        if (Kijkenrechts) {
            setImage("p" + waardeCoin + "_stand.png");
        } else {
            setImage("p" + waardeCoin + "_invstand.png");
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



    public int Sterrenteller(int ster) {
        sterren = sterren + ster;
        getWorld().showText("Sterren: " + sterren, 100, 100);
        return sterren;
    }
    public void Lock(){
    if (isTouching(BlueLock.class) && BlueKey) {
            removeTouching(BlueLock.class);
    }
   }
}
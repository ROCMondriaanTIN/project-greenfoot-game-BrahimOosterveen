import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 * @author R. Springer
 */
public class MyWorld extends World {

    private CollisionEngine ce;
    int level = 1;

    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public MyWorld() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1, false);
        this.setBackground("bg.png");

        int[][] map = {
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,186,-1,-1,-1},
                {-1,-1,-1,-1,185,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,185,-1,-1,-1,-1,-1,-1,-1,185,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,186,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,187,-1,186,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-82,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,75,-1,-1,-1,77,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,82,82,82,82,83,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,75,76,-1,-1,-1,78,77,-1,-1,-1,-1,-1,-1,82,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,128,-1,-1,-1,-1,-1,-1,75,76,65,95,95,95,65,78,77,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,81,82,83,-1,-1,-1,-1,75,76,65,65,93,93,93,65,65,78,77,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,128,-1,-1,-1,-1,-1,-1,-1,-1,-1,81,82,83,-1,-1,-1,-1,-1,-1,-1,-1,82,82,76,65,65,65,93,93,93,65,65,65,78,82,82,82,82,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,-1,-1,81,82,83,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,19,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,19,-1,81,82,83,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,19,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,19,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,19,-1,-1,168,-1,-1,168,-1,-1,168,-1,-1,-1,36,36,36,19,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,65,65,65,65,65,65,65,65,65,65,65,65,65,65,-1,-1,-1,-1,81,82,83,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,19,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,98,-1,-1,-1,-1,-1,-1,81,82,83,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,65,65,65,65,65,65,65,65,65,65,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,81,82,83,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,19,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,98,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,96,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,19,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,-1,-1,-1,-1,-1,-1,-1,82,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,96,-1,-1,81,82,83,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,127,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,96,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,81,82,82,83,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,128,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,96,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,77,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,75,82,82,82,77,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,75,76,65,65,65,78,77,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,81,82,83,-1,-1,-1,-1,-1,-1},
                {65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,-1,-1,-1,-1,-1,-1,128,-1,-1,75,76,65,65,65,65,65,78,77,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,-1,-1,-1,82,82,82,82,82,82,76,65,65,65,65,65,65,65,78,77,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,128,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,95,95,95,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,78,77,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,75,82,82,82,82,95,95,95,82,82,82,82,82,82,82,82,82,82,97,97,97},
                {65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,93,93,93,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,78,82,-1,-1,-1,82,82,97,97,82,82,82,82,76,65,65,65,65,65,65,65,65,65,65,65,65,65,65,150,-1,-1,-1,-1,-1},
                {65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,93,93,93,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,150,-1,-1,150,150,150,150,150,150,150,150,150,150,150,150,150,150,150,150,150,150,150,150,-1,-1,-1,-1,150},
                {65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,93,93,93,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,150,-1,-1,-1,168,-1,-1,-1,-1,168,-1,-1,-1,-1,-1,168,-1,-1,-1,-1,168,-1,-1,-1,-1,-1,150,150},
                {65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,93,93,93,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,150,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,150,150,65},
                {65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,93,93,93,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,150,150,150,150,150,150,150,150,150,150,150,150,150,150,150,150,150,150,150,150,150,150,150,150,150,150,65,65},
                {65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,93,93,93,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65,65},
            };

        // Declareren en initialiseren van de TileEngine klasse om de map aan de world toe te voegen
        TileEngine te = new TileEngine(this, 60, 60, map);
        // Declarenre en initialiseren van de camera klasse met de TileEngine klasse 
        // zodat de camera weet welke tiles allemaal moeten meebewegen met de camera
        Camera camera = new Camera(te);
        // Declareren en initialiseren van een main karakter van het spel mijne heet Hero. Deze klasse 
        // moet de klasse Mover extenden voor de camera om te werken
        Hero hero = new Hero(level);

        // Laat de camera een object volgen. Die moet een Mover instatie zijn of een extentie hiervan.
        camera.follow(hero);

        // Alle objecten toevoegen aan de wereld: camera, main karakter en mogelijke enemies
        addObject(camera, 0, 0);
        //addObject(new Platform(), 2151, 745);
        addObject(hero, 250, 1100);
        
        addObject(new KeyHud("hud_keyBlue_disabled.png"), 50, 750);
        addObject(new KeyHud("hud_keyGreen_disabled.png"), 100, 750);
        addObject(new KeyHud("hud_keyRed_disabled.png"), 150, 750);
        addObject(new KeyHud("hud_keyYellow_disabled.png"), 200, 750);
        addObject(new KeyHud("hud_gem_blueempty.png"), 900, 750);
        addObject(new KeyHud("Gouden_nonster.png"), 820,100);
        addObject(new KeyHud("Gouden_nonster.png"), 890, 100);
        addObject(new KeyHud("Gouden_nonster.png"), 960, 100);
        
        
        
        addObject(new Enemy(), 2377, 1430);
        addObject(new Slijmenemy(), 2983, 887);
        addObject(new Fireball(), 1886, 435);
        addObject(new Deur(), 2600, 865);
        addObject(new deurkapje(), 2600, 800);
        addObject(new BlueKey(), 1192, 1053);
        addObject(new Bluecoin(), 1473, 735);
        
        //addObject(new Greencoin(), 800, 1000);
        addObject(new YellowKey(), 384, 250);
        addObject(new GreenKey(), 2386, 1324);
        addObject(new RedKey(), 3323, 1205);
        addObject(new Diamand(), 3823, 75);
        addObject(new Ster(), 3322, 1635);
        addObject(new Ster(), 3384, 675);
        addObject(new Ster(), 2916, 125);
        // addObject(new Platform(), 400, 1100);
        
        
        

        // Force act zodat de camera op de juist plek staat.
        camera.act();
        hero.act();

        // Initialiseren van de CollisionEngine zodat de speler niet door de tile heen kan lopen.
        // De collision engine kijkt alleen naar de tiles die de variabele solid op true hebben staan.
        ce = new CollisionEngine(te, camera);
        // Toevoegen van de mover instantie of een extentie hiervan
        ce.addCollidingMover(hero);
        prepare();
    }

    @Override
    public void act() {
        ce.update();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        Reset reset = new Reset(level);
        addObject(reset,38,38);


    }
}

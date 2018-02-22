
import objectdraw.*;
import java.awt.*;
import java.util.Random;

/**
 * Erika Sklaver
 * Lab 4 - Growing Flowers
 * Section 2
 * 03/24/15
 * 
 * Creates a flower that consists of a sprout, a stem and petals. Methods include the petals changing colors,
 * the flower, growing from the sprout, the entire flower withering and knowing if the petals are showing 
 * or not (if the flower has blossomed). 
 *
 * 
 */
public class Flower {
    
    //the sprout of the flower
    private FilledOval sprout; 
    
    //the stem of the flower
    private FilledRect stem; 
    
    //diameter of the sprout
    private static final int SPROUT_SIZE = 20; 
    
    //width of the stem
    private static final int STEM_WIDTH = 5; 
    
    //randomly generates petal colors
    private Random generator = new Random (); 
    
    
    //creates the petals, random color and size of petals 
    private FilledOval petal1;
    private FilledOval petal2;
    private static final int PETAL_WIDTH = 60; 
    private static final int PETAL_HEIGHT = 30; 
    private Color petalColor; 
    private int colorCode1; 
    private int colorCode2;
    private int colorCode3;
    
   //allows the stem to grow 
    private double maxHeight;
    private double currentHeight; 
    private static final double STEM_GROWTH = 1; 
   
    //the size of the sun 
    private static final int SUN_X = 20;
    private static final int SUN_Y = 20; 
    private static final int SUN_DIAM = 50;
    
    //allows Drawing canvas to be refrenced throughout the class 
    private DrawingCanvas theCanvas; 
    
    //name for the sun class 
    private Sun sun;
    
    //remembers whether the petals have bloomed or not  
    public boolean grownPetal = false; 
    
    public Flower(Location xy, double maxHeight, DrawingCanvas theCanvas) {
         
        //allows maxHeight to be used in other methods
         this.maxHeight = maxHeight;
         
         this.theCanvas = theCanvas;
       
         //creates the sprout, stem and petals of the flower
        sprout = new FilledOval(xy.getX()-SPROUT_SIZE/2, xy.getY()-SPROUT_SIZE/2, SPROUT_SIZE, SPROUT_SIZE, theCanvas); 
        sprout.setColor(Color.RED); 
        stem = new FilledRect(xy.getX()-STEM_WIDTH/2, xy.getY(), STEM_WIDTH, currentHeight, theCanvas);
        stem.setColor(Color.GREEN); 
        petal1 = new FilledOval(xy.getX()-PETAL_WIDTH/2, xy.getY()-PETAL_HEIGHT/2, PETAL_WIDTH, PETAL_HEIGHT, theCanvas); 
        petal2 = new FilledOval(xy.getX()-PETAL_HEIGHT/2, xy.getY()-PETAL_WIDTH/2, PETAL_HEIGHT, PETAL_WIDTH, theCanvas); 
        
        //sets the height of the stem to start off as O
        currentHeight = 0; 
        
        //allows the flower to look like a flower
        sprout.sendToFront(); 
         
        
        //the user cannot see the petals right away
        petal1.hide();
        petal2.hide(); 
        
        //allows the first shown petals to have a random color
        colorCode1 = generator.nextInt(256);
        colorCode2 = generator.nextInt(256);
        colorCode3 = generator.nextInt(256);
        petalColor = new Color(colorCode1, colorCode2, colorCode3); 
        petal1.setColor(petalColor); 
        petal2.setColor(petalColor);
        
        
        
    }
    
    public void changeColor(){
        //allows the petals to change colors randomly
        colorCode1 = generator.nextInt(256);
        colorCode2 = generator.nextInt(256);
        colorCode3 = generator.nextInt(256);
        petalColor = new Color(colorCode1, colorCode2, colorCode3); 
        petal1.setColor(petalColor); 
        petal2.setColor(petalColor);
        
    }
    
    public boolean flowerContains(Location point){
        //remembers whether the user clicked on the petals/sprout or not 
        return sprout.contains(point)||petal1.contains(point)||petal2.contains(point);

    }
    
    public void grow(Sun sun){
      
      
        if (currentHeight<maxHeight){
            //if the stem isn't at it's maximum height it will keep growing
            currentHeight = currentHeight + STEM_GROWTH ; 
            stem.setHeight(currentHeight);
            stem.move(0, -STEM_GROWTH);
            sprout.move(0, -STEM_GROWTH); 
            petal1.move(0, -STEM_GROWTH); 
            petal2.move(0, -STEM_GROWTH);
         
       }else if (currentHeight == maxHeight && sun.sunIsOut()){
        
        //if the stem reaches its maximum height the petals will appear
        petal1.show(); 
        petal2.show();
        grownPetal = true; 
       }
    
    
    }
 
     public void wither(){
      //if the sun is not out the flower will disappear 
      sprout.hide(); 
      stem.hide(); 
      petal1.hide();
      petal2.hide();
    
     }

   public boolean hasBlossomed(){
    //remembers whether the petals are visible or not    
    if (grownPetal == true){
       return true;
    }else {
        return false;
    }
   }
    
}

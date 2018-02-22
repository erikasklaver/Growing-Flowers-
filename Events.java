import objectdraw.*;
import java.awt.*;

/**
 * Erika Sklaver
 * Lab 4 - Growing Flowers
 * Section 2
 * 03/24/15
 * 
 * When the user opens the window, a sun, ground and 1-3 furrows should appear. When the user clicks on 
 * a furrow, a red sprout should appear. When the user drags around the mouse a stem should grow. Also, 
 * when the user clicks on a furrow, the sun should either remain where it is or disappear randomly.
 * Once the flower grows to its maximum height, if the sun is out, randomly colored petals will appear. 
 * If the sun is not out, no petals will appear and when the user releases the mouse, the sprout and stem will
 * disappear. 
 * 
 */
public class Events extends FrameWindowController {

    // The most recently created flower.
    private Flower lastFlower;
    
    //the height of the ground
    private static final int GROUND_HEIGHT = 100; 
    
    //the name of the ground object
    private Ground soil; 
    
    //the sun object and its size
    private Sun sun; 
    private static final int SUN_X = 20;
    private static final int SUN_Y = 20; 
    private static final int SUN_DIAM = 50; 
    
    //the number of furrows in the ground
    private static final int FURROW_NUM = 3;
    
    public void begin(){
        
        
        //creates the ground when the window opens
        soil = new Ground (GROUND_HEIGHT, canvas); 
      
        //creates the furrows in the ground when the window opens 
        soil.digFurrows(FURROW_NUM); 
        
        //creates the sun in the corner of the window
        sun = new Sun(SUN_X, SUN_Y, SUN_DIAM, canvas); 
        
        
    }

    
    public void onMousePress(Location point) {

        //if the flower exists and the user clicks on the petals, the petals will change colors randomly
        if (lastFlower != null && lastFlower.flowerContains(point)) {
            lastFlower.changeColor();
        }
        
        //if the user clicks on a furrow, the sun will randomly appear or disappear and a new flower
        //will form 
         if (soil.furrowContains(point)){
            sun.randomSunComesOut();
            lastFlower = new Flower(point, canvas.getHeight()/3, canvas);
        
    
        }
    
     
        
    }

    
    public void onMouseDrag(Location point) {

       //Make the newest flower grow when the mouse is dragged

        if (lastFlower != null) {
            lastFlower.grow(sun);
       }

    }

    // Clear the canvas to start again when mouse moves
    // into window
    public void onMouseEnter(Location pt) {
        //when the mouse enters the screen, all existing flowers are removed
        canvas.clear();
         
        //when the mouse enters the screen the ground, furrows and sun will not disappear 
        soil = new Ground (GROUND_HEIGHT, canvas); 
        
        soil.digFurrows(FURROW_NUM); 
        
        sun = new Sun(SUN_X, SUN_Y, SUN_DIAM, canvas); 
    }
    
    public void onMouseRelease (Location point){
        //if the sun is not out, when the user releases the mouse, the flower should disappear
        if (lastFlower != null && lastFlower.hasBlossomed() == false ){
            lastFlower.wither(); 
            
      }
    }
    
   

}

import objectdraw.*;
import java.awt.*;
import java.util.Random;

/**
 * The sun Class creates a sun that is yellow. It will randomly appear with a probability of 1/2. 
 * 
 * Erika Sklaver
 * 03/24/15
 */

public class Sun
{
    //creates a filled oval that will be the sun 
    private FilledOval sun; 
    
    //creates a random number generator that allows the sun to randomly appear or disappear
    private Random generator = new Random(); 
    
    //the probability that the sun will come out
    private static final double PROB = 0.5;
    
    //remembers whether the sun is showing or not
    private boolean sunOut = false; 
    
    
    public Sun(double xpos, double ypos, double diameter, DrawingCanvas theCanvas){
        //creates a yellow sun 
        sun = new FilledOval (xpos, ypos, diameter, diameter, theCanvas); 
        sun.setColor(Color.YELLOW); 
        
        
    }
    
    public void randomSunComesOut(){
        
        //generates the random number which allows the sun to randomly appear
        if (generator.nextDouble()<PROB){
            //if the randomly generated number is less than .5, the sun will appear
            sun.show(); 
            sunOut = true; 
        
        }else{
            //otherwise, the sun will disappear
            sun.hide(); 
            sunOut = false; 
        }

   }
   
   //remembers whether the sun is visible or not 
   public boolean sunIsOut(){
      
       if (sunOut == true) {
           return true;
        }else {
            return false;
        }
    }
}

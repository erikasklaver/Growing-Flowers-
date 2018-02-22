import objectdraw.*;
import java.awt.*;
import java.util.Random;

/**
 * The Ground is a brown rectangular box at the bottom of the window that can contain anywhere from 1 to
 * 3 furrows which are black ovals in the ground. The furrows are where flowers are grown from. 
 * 
 * Erika SKlaver
 * 03/24/15
 */
public class Ground
{
   
    //creates the brown rectangle that represents the ground
    private FilledRect dirt; 
    private Color brown = new Color(75, 50, 25);
    private double dirtHeight;
    
    private DrawingCanvas theCanvas; 
    
    
    //the furrows
    private FilledOval furrow1;
    private FilledOval furrow2;
    private FilledOval furrow3;

    
    public Ground (double dirtHeight, DrawingCanvas theCanvas){
        //allows these variables to be refrenced throughout the class
        this.dirtHeight=dirtHeight;
        this.theCanvas=theCanvas; 
        
        //creates the brown ground
        dirt = new FilledRect (0, theCanvas.getHeight()-dirtHeight, theCanvas.getWidth(), dirtHeight, theCanvas); 
        dirt.setColor(brown); 
        
       
        
    }
   
    
    
    public void digFurrows (int number) {
        
        //variables used for the furrows location and size 
        double FURROW_HEIGHT = dirtHeight/10; 
        double FURROW_X = theCanvas.getWidth()/9;
        double FURROW_WIDTH = theCanvas.getWidth()-FURROW_X - FURROW_X;
        
        //creates the furrows depending on what number is placed in the Events class 
        if (number==1){
            furrow1 = new FilledOval (FURROW_X, theCanvas.getHeight()-dirtHeight/2-FURROW_HEIGHT, FURROW_WIDTH, FURROW_HEIGHT, theCanvas);
            
        }else if (number==2){
            furrow1 = new FilledOval (FURROW_X, theCanvas.getHeight()-dirtHeight/4-FURROW_HEIGHT, FURROW_WIDTH, FURROW_HEIGHT, theCanvas); 
            
            furrow2 = new FilledOval (FURROW_X, theCanvas.getHeight()-3*dirtHeight/4-FURROW_HEIGHT, FURROW_WIDTH, FURROW_HEIGHT, theCanvas);
            
        }else if (number==3){
            furrow1= new FilledOval (FURROW_X, theCanvas.getHeight()-dirtHeight/6-FURROW_HEIGHT, FURROW_WIDTH, FURROW_HEIGHT, theCanvas); 
            
            
            furrow2= new FilledOval (FURROW_X, theCanvas.getHeight()-dirtHeight/2-FURROW_HEIGHT, FURROW_WIDTH, FURROW_HEIGHT, theCanvas); 
            
            
            furrow3= new FilledOval (FURROW_X, theCanvas.getHeight()-5*dirtHeight/6-FURROW_HEIGHT, FURROW_WIDTH, FURROW_HEIGHT, theCanvas); 
            
        }
            
            
    
    
     }

      public boolean furrowContains(Location point){
        
       //ensures that the furrows exist before they are used for flower growth  
      if (furrow1 != null && furrow1.contains(point)){
        return true;
      }else if (furrow2 != null && furrow2.contains(point)){
        return true;
      }else if (furrow3 != null && furrow3.contains(point)){
        return true;
      }else {
        return false;
      }

    
      }

    
}

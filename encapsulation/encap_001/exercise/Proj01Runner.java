//
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;


class Proj01Runner{

    
    //Constructor
    public Proj01Runner(){
        System.out.println("Alan Cugler.");}

    
    //Setting World size
    Picture picture = new Picture("Proj01.jpg");
    private World mars = new World(picture.getWidth(),picture.getHeight());

    
    //Setting Turtles in mars
    private Turtle forceshield = new Turtle(mars);
    private Turtle lightsaber = new Turtle(mars);

    
    //Setting run function
    public void run(){    
        mars.setPicture(new Picture("Proj01.jpg"));}


    //Setting explore function
    public void explore(){

        //Cross hairs width
        forceshield.hide();
        forceshield.setPenWidth(2);
        forceshield.setPenColor(Color.PINK);
        forceshield.penUp();
        forceshield.moveTo(mars.getWidth(),mars.getHeight()/2);
        forceshield.penDown();
        forceshield.moveTo(0,mars.getHeight()/2);
        forceshield.penUp();

        //Cross hairs height
        lightsaber.hide();
        lightsaber.setPenWidth(2);
        lightsaber.setPenColor(Color.PINK);
        lightsaber.penUp();
        lightsaber.moveTo(mars.getWidth()/2,mars.getHeight());
        lightsaber.penDown();
        lightsaber.moveTo(mars.getWidth()/2,0);
        lightsaber.penUp();
        
        //Half Circle
        forceshield.moveTo(mars.getWidth()/2,mars.getHeight()/4);
        forceshield.setPenWidth(4);
        forceshield.setPenColor(Color.CYAN);
        forceshield.penDown();
        //forceshield.moveTo(197, 147);
        forceshield.setPenWidth(3);
        forceshield.setPenColor(Color.RED);
        //forceshield.moveTo(XXXXXXXXXXXXXXXX);
        forceshield.penUp();
        
        //Lightsaber
        //lightsaber.moveTo(157, 177);
        lightsaber.setPenWidth(3);
        lightsaber.setPenColor(Color.YELLOW);
        lightsaber.penDown();
        //lightsaber.moveTo(XXXXXXXXXXXXXXXX);

    }


    //maybe done?
    public Turtle getForceshield(){return forceshield;}

    //maybe done?
    public Turtle getLightsaber(){return lightsaber;}

    //maybe done?
    public Picture getMars(){return mars.getPicture();}
}

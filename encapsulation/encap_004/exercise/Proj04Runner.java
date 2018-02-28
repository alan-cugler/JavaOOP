import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;


class Proj04Runner{
    
    //Class variables
    Picture picture = new Picture("Proj04.jpg");
    private Turtle budlight;
    private Pixel pix;
    private Pixel[] pixArray = picture.getPixels();
    private int xCor, yCor, col, row, green, red, blue;
    private int width = picture.getWidth();
    private int height = picture.getHeight();
    private int[] latitude, longitude;
    private double xOff, yOff, xScale, yScale, yVal, xVal, greenScale, redScale, blueScale;


    //Constructor
    public Proj04Runner(){
        System.out.println("Alan Cugler.");}


    //Picture modifications & publication
    public Picture run(){


        //Setting class variables value
        budlight = new Turtle(320,240,picture);
        latitude = new int[320];
        longitude = new int[240];

        xOff = 0.0;
        yOff = -0.55;
        xScale = 1.0*width/2;
        yScale = 0.9*height/2;
        yVal = 0;
        xVal = -1;

        greenScale = 0;
        redScale = 0;
        blueScale = 0;

        //In picture message
        picture.addMessage("I certify that this", 3, 18);
        picture.addMessage("program is my own", 3, 36);
        picture.addMessage("work and is not the", 3, 54);
        picture.addMessage("work of others.", 3, 72);
        picture.addMessage("Alan Cugler.", 3, 90);


        //Vertical Y-axis line
        budlight.hide();
        budlight.penUp();
        budlight.setPenWidth(2);
        budlight.setPenColor(Color.GREEN);
        budlight.moveTo(width/2,0);
        budlight.penDown();
        budlight.moveTo(width/2,height);
        budlight.penUp();


        //Parabola line
        for(int cnt=0; cnt<=100;cnt++,xVal += 0.02){
            yVal = xVal*xVal;

            col = (int)((xOff+xVal)*xScale);
            row = (int)((yOff+yVal)*yScale);

            if (col + width/2 < 350 && col + width/2 > -1){
                if (row + height/2 < 280 && row + height/2 > -1){
                    budlight.moveTo(col + width/2, row + height/2);
                    budlight.penDown();
                }
            }
        }   





        

        //Publish the modified picture
        picture.explore();

        return picture;
    }   
}

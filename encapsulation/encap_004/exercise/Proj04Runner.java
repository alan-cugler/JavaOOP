
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;


class Proj04Runner{
    
    //Class variables
    Picture picture = new Picture("Proj04.jpg");
    private Turtle budlight;
    private Pixel pix, topPixel, bottomPixel, leftPixel, rightPixel;
    private Pixel[] pixArray = picture.getPixels();
    private int xCor, yCor, col, row, green, red, blue, cnt;
    private int width = picture.getWidth();
    private int height = picture.getHeight();
    private int[] latitude, longitude;
    private double xScale, yScale, yVal, xVal, curveLine;


    //Constructor
    public Proj04Runner(){
        System.out.println("Alan Cugler.");}


    //Picture modifications & publication
    public Picture run(){

        //In picture message
        pictureMessage();

        //Drawing middle seperation line
        turtleLines();

        //Drawing Parabola & mirror copying
        mirrorSides();

        //Mirroring top half to bottom
        mirrorHoriz();

        //Changing colors of bottom half
        bottomColorInversion();

        //Publishing picture object
        picture.explore();

        return picture;
    }

    private void turtleLines(){

        budlight = new Turtle(width, height, picture);

        budlight.hide();
        budlight.penUp();
        budlight.setPenWidth(2);
        budlight.setPenColor(Color.GREEN);
        budlight.moveTo(width/2,0);
        budlight.penDown();
        budlight.moveTo(width/2,height);
        budlight.penUp();
    }
    

    //Pictue Message function
    private void pictureMessage(){

        picture.addMessage("I certify that this", 3, 18);
        picture.addMessage("program is my own", 3, 36);
        picture.addMessage("work and is not the", 3, 54);
        picture.addMessage("work of others.", 3, 72);
        picture.addMessage("Alan Cugler.", 3, 90);
    }

    
    //Left/Right inversion function
    private void mirrorSides(){

        yScale = 1.0*height/2;

        for(xCor = 0; xCor < width/2; xCor++){
            for(yCor = 0; yCor < height/2; yCor++){
                
                xVal = ((double)((xCor) / (double)(width/2)));
                yVal = xVal * xVal;
                curveLine = yVal * yScale;

                leftPixel = picture.getPixel(xCor,yCor);
                rightPixel = picture.getPixel(width-1-xCor, yCor);

                if((double)yCor < curveLine + 1.0 && (double)yCor > curveLine){
                    leftPixel.setColor(Color.RED);
                }
                
                if((double)yCor > curveLine){
                    rightPixel.setColor(leftPixel.getColor());
                }
            }
        }
    }
    
    //Top/bottom inversion Function
    private void mirrorHoriz(){

        for(xCor = 0; xCor < width; xCor++){
            for(yCor = 0; yCor < height/2; yCor++){
                
                topPixel = picture.getPixel(xCor,yCor);
                bottomPixel = picture.getPixel(xCor,height-1-yCor);
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }


    //Bottom color inversion function
    private void bottomColorInversion(){
        
        for(xCor = 0; xCor < width; xCor++){
            for(yCor = height/2; yCor < height; yCor++){
                
                pix = picture.getPixel(xCor,yCor);

                red = pix.getRed();
                green = pix.getGreen();
                blue = pix.getBlue();
                
                pix.setRed(255 - red);
                pix.setGreen(255 - green);
                pix.setBlue(255 - blue);
            }
        }
    }
}

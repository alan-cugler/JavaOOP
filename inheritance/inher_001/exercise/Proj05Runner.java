
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;


class Proj05Runner extends Proj05{

    //Class variables
    Picture picture = new Picture(392, 293);
    Picture background = new Picture("Proj05c.jpg");
    Picture floor = new Picture("Proj05b.bmp");
    Picture person = new Picture("Proj05a.bmp");
    private Turtle budlight;
    private Pixel pix, pix2, topPixel, bottomPixel, leftPixel, rightPixel;
    private Pixel[] pixArray = picture.getPixels();
    private int xCor, yCor, col, row, green, red, blue, cnt;
    private int width = background.getWidth();
    private int height = background.getHeight();
    private int[] latitude, longitude;
    private double xScale, yScale, yVal, xVal, curveLine;


    //Constructor
    public Proj05Runner(){System.out.println("Alan Cugler.");}


    //Picture modifications & publication
    public void run(){

        background.explore();
        backgroundColoring();
        floorSetting();
        personSetting();
        parabola();
        pictureMessage();
        pictureTriming();
        picture.explore();
    }

    private void backgroundColoring(){
        for(xCor = 7; xCor < width-7; xCor++){
            for(yCor = 60; yCor < height-8; yCor++){

                pix = background.getPixel(xCor, yCor);

                red = pix.getRed();
                green = pix.getGreen();
                blue = pix.getBlue();

                if(blue > 200 && red < 30 && green < 30){
                    pix.setRed(0);
                    pix.setGreen(0);
                    pix.setBlue(177);
                }
                
                if((yCor > 209 && xCor < 172) || (yCor > 209 && xCor > 280) || (yCor > 211)){
                    pix.setRed(red - 70);
                    pix.setGreen(green - 70);
                    pix.setBlue(blue - 70);
                }

                if(red != 0 && green != 0 && blue != 177 && yCor < 210){
                    pix.setRed(red - 40);
                    pix.setGreen(green - 40);
                    pix.setBlue(blue - 40);
                }
                if(blue > 200){
                    pix.setBlue(177);
                }
            }
        }
    } 

    //
    private void floorSetting(){
        for(xCor = 7; xCor < width-7; xCor++){
            for(yCor = 60; yCor < height-8; yCor++){

                pix = floor.getPixel(xCor, yCor);
                pix2 = background.getPixel(xCor, yCor);

                green = pix.getGreen();
                
                if(green != 255){
                    
                    pix2.setRed(255);
                    pix2.setGreen(255);
                    pix2.setBlue(0);
                }
            }
        }
    }


    //
    private void personSetting(){
        for(xCor = 7; xCor < width-7; xCor++){
            for(yCor = 60; yCor < height-8; yCor++){

                pix = person.getPixel(xCor, yCor);
                pix2 = background.getPixel(xCor, yCor);

                green = pix.getGreen();

                if(green != 255){ 
                    pix2.setRed(pix.getRed());
                    pix2.setGreen(pix.getGreen());
                    pix2.setBlue(0);
                }
            }
        }
    }


    //
    private void parabola(){
        
        xScale = 0.875 * (double)height/2;

        for (xCor = 0; xCor < width; ++xCor){
            for (yCor = 0; yCor < height; ++yCor) {

                yVal = cubic(-1 * (double)(xCor-width/2) / (double)(width/2));
                curveLine = xScale * yVal + (double)(height/2);


                //drawing line
                if ((double)yCor < curveLine + 1.8 && (double)yCor > curveLine - 1.8) {
                    for(cnt = 0; cnt < 3; cnt++){
                        for(row = 0; row < 4; row++){

                            pix = background.getPixel(xCor+cnt+15, yCor);
                            pix.setRed(255);
                            pix.setGreen(200);
                            pix.setBlue(0);
                            
                            if(yCor < 12*height/16){

                                pix = background.getPixel(xCor+cnt+15, yCor+row);
                                pix.setRed(255);
                                pix.setGreen(200);
                                pix.setBlue(0);
                            }
                        }
                    }
                }
            }
        }
    }


    //Cubic parabola function
    private double cubic(double xVal){

        yVal = 10.0*xVal*xVal*xVal - 0.5*xVal*xVal + 0.05*xVal + 0.8;
        return yVal;
    }

    
    //Pictue Message function
    private void pictureMessage(){

        background.addMessage("I certify that this program is my own work", 16, 118);
        background.addMessage("and is not the work of others. I agree not", 16, 136);
        background.addMessage("to share my solution with others.", 16, 154);
        background.addMessage("Alan Cugler.", 16, 172);
    }


    //Removing previous picture borders
    private void pictureTriming(){
        for(xCor = 7; xCor < width-7; xCor++){
            for(yCor = 60; yCor < height-8; yCor++){

                pix = background.getPixel(xCor, yCor);
                pix2 = picture.getPixel(xCor-7, yCor-60);

                pix2.setRed(pix.getRed());
                pix2.setGreen(pix.getGreen());
                pix2.setBlue(pix.getBlue());
            }
        }
    }
}

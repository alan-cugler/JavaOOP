import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

class Proj08RunnerB{

    //Class variables
    private Picture pic = new Picture(350, 125);
    private int a, b, yCor, xCor;
    private int width = pic.getWidth();
    private int height = pic.getHeight();
    private Pixel thePixel;

    //Constructor
    public Proj08RunnerB(){
        
    }

    public void getDataFromObj(Object o){
        
        a = ((Proj08RunnerA)o).getint();
        redPicture();
        pictureMessage(a);
        World vas = new World(350, 125);
        vas.setPicture(pic);
    }

    private void pictureMessage(int a){

        pic.addMessage("I certify that this program is my own work", 10, 20);
        pic.addMessage("and is not the work of others. I agree not", 10, 38);
        pic.addMessage("to share my solution with others.", 10, 56);
        pic.addMessage("Alan Cugler.", 10, 74);
        pic.addMessage("a1774678", 10, 92);
        pic.addMessage(Integer.toString(a), 10, 110);
    }

    private void redPicture(){

        for(xCor = 0; xCor < width; xCor++){
            for(yCor = 0; yCor < height; yCor++){

                thePixel = pic.getPixel(xCor,yCor);
                thePixel.setRed(255);
                thePixel.setGreen(0);
                thePixel.setBlue(0);
            }
        }
    }
}

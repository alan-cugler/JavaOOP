import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;


class Proj06Runner extends Proj06{

    //Class variables
    Picture picture = new Picture("Proj06.jpg");
    private Turtle budlight;
    private Pixel pix, leftPixel, rightPixel, middleMan;
    private Pixel[] pixArray = picture.getPixels();
    private int xCor, yCor, col, row, green, red, blue;
    private int width = picture.getWidth();
    private int height = picture.getHeight();
    private int[] latitude, longitude;
    private double xScale, yScale, yVal, xVal, curveLine;


    //Constructor
    public Proj06Runner(){

        System.out.println("Alan Cugler.");}


    //Picture modifications & publication
    public void run(double option){

        //In picture message
        pictureMessage();

        //Drawing Parabola & mirror copying
        mirrorPicture();

        //Mirroring top half to bottom
        pic = rotatePicture(pic, option);
    }

    
    public void run(int option){
        
        //In picture message
        pictureMessage();

        //Mirroring top half to bottom
        pic = rotatePicture(pic, (double)option);
    }


    private void pictureMessage(){

        pic.addMessage("I certify that this program is my own work", 10, 15);
        pic.addMessage("and is not the work of others. I agree", 10, 30);
        pic.addMessage("to share my solution with others.", 10, 45);
        pic.addMessage("Alan Cugler.", 10, 60);
    }


    private void mirrorPicture(){

        for(xCor = 0; xCor < width; xCor++){
            for(yCor = 0; yCor < height; yCor++){

                leftPixel = pic.getPixel(xCor,yCor);
                rightPixel = picture.getPixel(xCor,height-1-yCor);
                                
                rightPixel.setColor(leftPixel.getColor());
            }
        }
        
        for(xCor = 0; xCor < width; xCor++){
            for(yCor = 0; yCor < height; yCor++){

                leftPixel = picture.getPixel(xCor,yCor);
                rightPixel = pic.getPixel(xCor,yCor);

                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }


    private Picture rotatePicture(Picture pic,double angle){

        AffineTransform rotateTransform =
            new AffineTransform();
        
        rotateTransform.rotate(Math.toRadians(angle),
                               pic.getWidth()/2,
                               pic.getHeight()/2);
        
        Rectangle2D rectangle2D =
            pic.getTransformEnclosingRect(rotateTransform);
        int resultWidth = (int)(rectangle2D.getWidth());
        int resultHeight = (int)(rectangle2D.getHeight());
        
        AffineTransform translateTransform =
            new AffineTransform();
        translateTransform.translate((resultWidth - pic.getWidth())/2,
                                     (resultHeight - pic.getHeight())/2);
        
        translateTransform.concatenate(rotateTransform);
        Picture result = new Picture(resultWidth,resultHeight);
        
        Graphics2D g2 = (Graphics2D)result.getGraphics();
        g2.drawImage(pic.getImage(),translateTransform,null);
        
        return result;
    }
}

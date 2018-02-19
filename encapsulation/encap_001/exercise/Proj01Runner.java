//
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;


class Proj01Runner{

    Picture picture = new Picture("Proj01.jpg");
    private Turtle forceshield, lightsaber;

    
    //Constructor
    public Proj01Runner(){
        System.out.println("Alan Cugler.");}

    double xOff = -0.0;
    double yOff = 0.01;
    double rVal = 0.56;
    double yVal = 0;
    int row = 0;
    int col = 0;
    double xVal = -rVal;
    double xInc = 2*rVal/100;

    double function(double rVal,double xVal){
        double yVal = Math.sqrt(rVal*rVal - xVal*xVal + 0.0000000001);
        return yVal;}
    
    //Setting run function
    public void run(){
        
        //Print on picture
        forceshield = new Turtle(picture.getWidth(),picture.getHeight()/2,picture);
        lightsaber = new Turtle(picture.getWidth()/2,picture.getHeight(),picture);
        
        picture.addMessage("I certify that this program is my own work", 20, 20);
        picture.addMessage("and is not the work of others. I agree not", 20, 40);
        picture.addMessage("to share my solution with others.", 20, 60);
        picture.addMessage("Alan Cugler.", 20, 80);
    
        //Cross hairs vertical
        lightsaber.hide();
        lightsaber.setPenWidth(2);
        lightsaber.setPenColor(Color.MAGENTA);
        lightsaber.penUp();
        lightsaber.moveTo(picture.getWidth()/2,picture.getHeight());
        lightsaber.penDown();
        lightsaber.moveTo(picture.getWidth()/2,0);
        lightsaber.penUp();

        double xScale = 1.0*picture.getHeight()/2;
        double yScale = 1.0*picture.getHeight()/2;
        
        //Red 1/4 circle
        forceshield.penUp();
        forceshield.hide();
        forceshield.setPenWidth(3);
        forceshield.setPenColor(Color.RED);
        for(int cnt=0; cnt<=50;cnt++,xVal += xInc){
            yVal = function(rVal,xVal);
            col = (int)((xOff+xVal)*xScale);
            row = (int)((yOff-yVal)*yScale);
            forceshield.moveTo(col + picture.getWidth()/2, row + picture.getHeight()/2);
            forceshield.penDown();};
        forceshield.penUp();
        
        //Cyan 1/4 Circle
        forceshield.setPenWidth(4);
        forceshield.setPenColor(Color.CYAN);
        forceshield.penUp();
        for(int cnt=0; cnt<=49;cnt++,xVal += xInc){
            yVal = function(rVal,xVal);
            col = (int)((xOff-xVal)*xScale);
            row = (int)((yOff+yVal)*yScale);
            forceshield.moveTo(col + picture.getWidth()/2, row + picture.getHeight()/2);
            forceshield.penDown();};
        forceshield.penUp();

        //Cross hairs horizontal
        forceshield.setPenWidth(2);
        forceshield.setPenColor(Color.MAGENTA);
        forceshield.penUp();
        forceshield.moveTo(picture.getWidth(),picture.getHeight()/2);
        forceshield.penDown();
        forceshield.moveTo(0,picture.getHeight()/2);
        forceshield.penUp();
        
        //Lightsaber
        lightsaber.setPenWidth(3);
        lightsaber.setPenColor(Color.YELLOW);
        lightsaber.moveTo(96*picture.getWidth()/200,114*picture.getHeight()/200);
        lightsaber.penDown();
        lightsaber.moveTo(39*picture.getWidth()/100,60*picture.getHeight()/100);
        lightsaber.penUp();
    }

    
    //maybe done?
    public Picture getMars(){
        return picture;}

    
    //Setting data before printing
    public Turtle getForceshield(){
        forceshield.setName("Forceshield");
        forceshield.moveTo(197, 147);
        forceshield.turn(90);
        return forceshield;}

    
    //Setting data before printing
    public Turtle getLightsaber(){
        lightsaber.setName("Lightsaber");
        lightsaber.moveTo(157, 177);
        return lightsaber;}
}

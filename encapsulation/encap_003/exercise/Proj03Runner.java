import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;


class Proj03Runner{

    //Class variables
    Picture picture = new Picture("Proj03a.bmp");
    private Turtle budlight;
    private Pixel pix;
    private int xCor, yCor, col, row, green, red, blue;
    private int width = picture.getWidth();
    private int height = picture.getHeight();
    private int[] latitude, longitude;
    private double xOff, yOff, xScale, yScale, yVal, xVal, greenScale, redScale, blueScale;

    
    //Constructor
    public Proj03Runner(){
        System.out.println("Alan Cugler.");}


    //Picture modifications & publication
    public void run(){

        budlight = new Turtle(348,279,picture);
        latitude = new int[348];
        longitude = new int[279];

        xOff = 0.0;
        yOff = -0.55;
        xScale = 1.0*width/2;
        yScale = 0.9*height/2;
        yVal = 0;
        xVal = -1;

        budlight.hide();
        budlight.penUp();
        budlight.setPenWidth(5);
        budlight.setPenColor(Color.RED);

        //Parabola line
        for(int cnt=0; cnt<=100;cnt++,xVal += 0.02){
            yVal = function(xVal);

            col = (int)((xOff+xVal)*xScale);
            row = (int)((yOff+yVal)*yScale);

            if (col + width/2 < 350 && col + width/2 > -1){
                if (row + height/2 < 280 && row + height/2 > -1){
                    budlight.moveTo(col + width/2, row + height/2);
                    budlight.penDown();
                }}}

        
        //Color fading
        greenScale = 0;
        redScale = 0;

        for(int xCor = 0; xCor < latitude.length; xCor++){
            for(int yCor = 0; yCor < longitude.length; yCor++){ 
                pix = picture.getPixel(xCor,yCor);
                green = pix.getGreen();
                red = pix.getRed();
                
                greenScale = (double)(width - xCor)/width;
                redScale = (double)(xCor)/width;
                pix.setGreen((int)(green * greenScale));
                pix.setRed((int)(red * redScale));
            }}

        
        //In picture message
        picture.addMessage("I certify that this program is my own work", 10, 20);
        picture.addMessage("and is not the work of others. I agree not", 10, 38);
        picture.addMessage("to share my solution with others.", 10, 56);
        picture.addMessage("Alan Cugler.", 10, 74);

        
        //Publish the modified picture
        picture.explore();
    }


    //Returns modified picture
    public Picture getPicture(){
        return picture;} 


    //
    double function(double xVal){
        yVal = xVal*xVal*xVal;
        return yVal;}  
}

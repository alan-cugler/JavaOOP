import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

class Proj03Runner{

    Picture picture = new Picture("Proj03a.bmp");
    private Turtle budlight;

    public Proj03Runner(){
        System.out.println("Alan Cugler.");}

    public void run(){

        budlight = new Turtle(348,279,picture);

        budlight.hide();
        budlight.penUp();
        budlight.setPenWidth(5);
        budlight.setPenColor(Color.RED);

        double xOff = 0.0;//done
        double yOff = -0.55;
        double xScale = 1.0*picture.getWidth()/2;
        double yScale = 0.9*picture.getHeight()/2;
        double yVal = 0;
        int row = 0;
        int col = 0;
        double xVal = -1;
        
        for(int cnt=0; cnt<=100;cnt++,xVal += 0.02){
            yVal = function(xVal);

            col = (int)((xOff+xVal)*xScale);
            row = (int)((yOff+yVal)*yScale);

            if (col + picture.getWidth()/2 < 350){
                if (col + picture.getWidth()/2 > -1){
                    if (row + picture.getHeight()/2 < 280){
                        if (row + picture.getHeight()/2 > -1){
                            budlight.moveTo(col + picture.getWidth()/2, row + picture.getHeight()/2);
                            budlight.penDown();
                        }}}}}

        picture.addMessage("I certify that this program is my own work", 10, 20);
        picture.addMessage("and is not the work of others. I agree not", 10, 38);
        picture.addMessage("to share my solution with others.", 10, 56);
        picture.addMessage("Alan Cugler.", 10, 74);
        
        picture.explore();
    }

        public Picture getPicture(){
            return picture;} 

    double function(double xVal){
        double yVal = xVal*xVal*xVal;
        return yVal;
    }





    
}

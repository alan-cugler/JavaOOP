import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

class Proj02Runner{

    Picture picture = new Picture("Proj02.jpg");
    private Turtle Redds;

    private Pixel pix;
    public int x, y;
    
    public int[] latitude = new int[394];
    public int[] longitude = new int[295];
    
    public Proj02Runner(){
        System.out.println("Alan Cugler.");}


    //Setting run function
    public void run(){

        //Print on picture
        Redds = new Turtle(394,295,picture);

        picture.addMessage("I certify that this program is my own work", 10, 20);
        picture.addMessage("and is not the work of others. I agree not", 10, 38);
        picture.addMessage("to share my solution with others.", 10, 56);
        picture.addMessage("Alan Cugler.", 10, 74);


        for(int x = 0; x < latitude.length; x++){
            for(int y = 0; y < longitude.length; y++){
                pix = picture.getPixel(x,y);
                if (y < (-0.397959*x-77)*-1){
                    pix.setRed(255 - pix.getRed());
                    pix.setGreen(255 - pix.getGreen());
                    pix.setBlue(127);
                }}}

        Redds.hide();
        Redds.setPenWidth(8);
        Redds.setPenColor(Color.RED);
        Redds.penUp();
        Redds.moveTo(0,55*picture.getHeight()/200);
        Redds.penDown();
        Redds.moveTo(picture.getWidth(),161*picture.getHeight()/200);
        Redds.penUp();
        
        picture.explore();
    }

        public Picture getPicture(){
            return picture;}
}

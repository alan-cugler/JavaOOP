import java.awt.Color;
class Proj03Runner{

    //Class variables
    Picture picture = new Picture("Proj03a.bmp");
    private Turtle budlight;
    private Pixel pix, topPixel, bottomPixel, leftPixel, rightPixel;
    private Pixel[] pixArray = picture.getPixels();
    private int xCor, yCor, col, row, green, red, blue, cnt;
    private int width = picture.getWidth();
    private int height = picture.getHeight();
    private int[] latitude, longitude;
    private double xScale, yScale, yVal, xVal;
    private double greenScale, redScale, blueScale, curveLine; 

    
    //Constructor
    public Proj03Runner(){
        System.out.println("Alan Cugler");
    }


    //Main function
    void run(){
    
        //Draws the parabola & color shading below it
        parabolaColoringLines();
        
        //Text added to picture
        pictureMessage();

        //Publishing modified picture
        picture.explore();
    }

    
    private void parabolaColoringLines(){

        xScale = 0.9 * (double)height/2;

        for (xCor = 0; xCor < width; ++xCor){
            for (yCor = 0; yCor < height; ++yCor) {

                pix = picture.getPixel(xCor, yCor);
                red = pix.getRed();
                green = pix.getGreen();

                greenScale = (double)(width - xCor)/width;
                redScale = (double)(xCor)/width;

                yVal = cubic((double)(xCor-width/2) / (double)(width/2));
                curveLine = xScale * yVal + (double)(height/4);


                //drawing line
                if ((double)yCor < curveLine + 5.0 && (double)yCor > curveLine - 5.0) {
                    pix.setColor(Color.RED);}

                //shading below the line
                else if ((double)yCor > curveLine) {
                    pix.setGreen((int)(green * greenScale));
                    pix.setRed((int)(red * redScale));
                }
            }
        }
    }

    
    //Pictue message function
    private void pictureMessage(){

        picture.addMessage("I certify that this program is my own work", 10, 20);
        picture.addMessage("and is not the work of others. I agree not", 10, 38);
        picture.addMessage("to share my solution with others.", 10, 56);
        picture.addMessage("Alan Cugler", 10, 74);
    }

    
    //Cubic parabola function
    private double cubic(double xVal){

        yVal = xVal*xVal*xVal;
        return yVal;
    }


    //Returns picture to calling program
    public Picture getPicture(){ return picture; }
}

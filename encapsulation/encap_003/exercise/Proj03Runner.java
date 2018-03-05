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
    private double xOff, yOff, xScale, yScale, yVal, xVal, greenScale, redScale, blueScale; 

    Picture getPicture(){
        return picture;
    }
    
    void run(){
        System.out.println("Alan Cugler");

        xScale = 0.9 * (double)height/2;

        for (xCor = 0; xCor < width; ++xCor){
            for (yCor = 0; yCor < height; ++yCor) {
                
                Pixel pixel = picture.getPixel(xCor, yCor);
                red = pixel.getRed();
                green = pixel.getGreen();
                blue = pixel.getBlue();
                
                double red_pixel_change = (double)xCor / (double)width;
                double green_pixel_change = (double)(width-xCor) / (double)width;
                
                double cubic = function((double)(xCor-width/2) / (double)(width/2));
                double curveLine = xScale * cubic + (double)(height/4);

                //drawing line
                if ((double)yCor < curveLine + 5.0 && (double)yCor > curveLine - 5.0) {
                    pixel.setColor(Color.RED);
                }

                //shading below the line
                else if ((double)yCor > curveLine) {
                    pixel.setRed((int)((double)red * red_pixel_change));
                    pixel.setGreen((int)((double)green * green_pixel_change));
                    pixel.setBlue((int)((double)blue));
                }}}

        picture.addMessage("I certify that this program is my own work", 10, 20);
        picture.addMessage("and is not the work of others. I agree not", 10, 38);
        picture.addMessage("to share my solution with others.", 10, 56);
        picture.addMessage("Alan Cugler", 10, 74);
        picture.explore();
    }
    
    

    double function(double xVal){
        double yVal = xVal*xVal*xVal;
        return yVal;
    }}

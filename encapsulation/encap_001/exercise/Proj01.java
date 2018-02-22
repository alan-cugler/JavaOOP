
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;


public class Proj01{

  public static void main(String[] args){
      
    Proj01Runner obj = new Proj01Runner();
    obj.run();
    Picture mars = obj.getMars();
    mars.explore();    

    System.out.println(obj.getForceshield());
    System.out.println(obj.getLightsaber());
  }
}

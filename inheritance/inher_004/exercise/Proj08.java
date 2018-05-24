import java.util.*;

class Proj08{
  public static void main(String[] args){

    Random generator = new Random(new Date().getTime());
    int randomNumber = (byte)generator.nextInt();

    Object[] objRef = {new Proj08RunnerA(randomNumber)};
    
    new Proj08RunnerB().getDataFromObj(objRef[0]);
    
    System.out.println(randomNumber);

  }
}

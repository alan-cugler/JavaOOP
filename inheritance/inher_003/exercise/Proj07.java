import java.util.*;

abstract class Proj07{
    public static void main(String[] args){

        Random generator = new Random(new Date().getTime());
        int firstRandomNumber = (byte)generator.nextInt();
        
        Proj07 objRef = new Proj07Runner(firstRandomNumber);
        System.out.println(objRef);
      
        int secondRandomNumber = (byte)generator.nextInt();
    
        System.out.println(objRef.getData(secondRandomNumber));
        System.out.println(firstRandomNumber);
        System.out.println(secondRandomNumber);
    }
    
    abstract int getData(int param);
}

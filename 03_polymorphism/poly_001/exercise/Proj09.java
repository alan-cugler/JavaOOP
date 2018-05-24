import java.util.*;

class Proj09{
  static String[] names = 
  {"Don","don","Bill","bill","Ann","ann","Chris","chris"};
  
  static String[] myArray = new String[8];
  
  public static void main(String args[]){

    Proj09Runner runner = new Proj09Runner();

    int seed = Integer.parseInt(args[0]);
    Random generator = new Random(seed);
    
    System.out.print("Input:  ");
    for(int cnt = 0;cnt < 8;cnt++){
      int index = ((byte)generator.nextInt())/16;
      if(index < 0){
        index = -index;
      }
      myArray[cnt] = names[index];
      System.out.print(myArray[cnt] + " ");
    }
    System.out.println();

    Collection collection = runner.getCollection(myArray);
 
    System.out.print("Output: ");
    Iterator iter = collection.iterator();
    while(iter.hasNext()){
      System.out.print(iter.next() + " ");
    }
    System.out.println();

  }
}

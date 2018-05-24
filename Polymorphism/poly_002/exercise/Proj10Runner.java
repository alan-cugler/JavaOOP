import java.util.*;

class Proj10Runner extends Proj10{
    
    public Proj10Runner(){
        
        System.out.println("I certify that this program is my own work");
        System.out.println("and is not the work of others. I agree not");
        System.out.println("to share my solution with others.");
        System.out.println("Alan Cugler.");
        System.out.println("");
    }

    public Collection getCollection(String[] x){

        ArrayList<String> list = new ArrayList<String>(Arrays.asList(x));
        Collections.sort((List)list, String.CASE_INSENSITIVE_ORDER);

        return list;
    }
}

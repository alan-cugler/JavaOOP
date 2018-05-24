import java.util.*;

class Proj12Runner extends Proj12{
    
    public Proj12Runner(){
        
        System.out.println("I certify that this program is my own work");
        System.out.println("and is not the work of others. I agree not");
        System.out.println("to share my solution with others.");
        System.out.println("Alan Cugler.");
        System.out.println("");
    }

    public Collection getCollection(String[] x){

        
        List<String> list = new ArrayList<String>(Arrays.asList(x));
        Set<String> list2 = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        list2.addAll(list);
        List<String> list3 = new ArrayList<String>();
        list3.addAll(list2);
        
        Collections.sort((List)list3, Collections.reverseOrder());
        
        return list3;
    }
}

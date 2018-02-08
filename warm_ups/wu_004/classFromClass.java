// Calling base class methods from other classes

class base{
    int i;
    void method(int a){
        i=a;
        System.out.println("value of i "+a);
    }
}

class secondClass{
    public static void main(String args[]){
        base object1=new base();
        object1.method(1234);
    }
}

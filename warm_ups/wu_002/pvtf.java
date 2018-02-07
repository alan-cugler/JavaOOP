// passing values in a function w/ object

class test{
    int a;
    void passvalue(int i){
        a=i;
        System.out.println("Value of a "+a);}
        //value from object call
        //assigned from local var to inst var
    public static void main(String args[]){
        test object1=new test();
        object1.passvalue(5);}
}

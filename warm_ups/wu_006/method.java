// Usign a method call to call  an instance variable

class test{
    int var;
    void setdata(int var){
        this.var=var;
        System.out.println("Value of var "+this.var);
    }

    public static void main(String args[]){
        test object1=new test();
        object1.setdata(1234);
    }
}

class Proj06{

  static Picture pic = new Picture("Proj06.jpg");

  public static void main(String[] args){
    Proj06 obj = new Proj06Runner();
    obj.run(18.0);
    pic.explore();

    pic = new Picture("Proj06.jpg");
    obj.run(-30);
    pic.explore();

  }

  void run(double hello){
    System.out.println("Hello World");
  }

  void run(int hello){
    System.out.println("Hello World");
  }
}

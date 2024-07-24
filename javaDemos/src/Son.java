public class Son extends  Father{

    String mather;

    public Son(String name, int age, String mather) {
        super(name, age);
        this.mather = mather;
    }

    public Son(String name, int age) {
        super(name, age);
    }


     public void talk()    {
        System.out.println("Son talk");
    }
}

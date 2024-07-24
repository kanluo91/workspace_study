public class Persion {
    private String name; // 姓名
    private int age;    //  年龄
    protected String sex;

    public Persion(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String sayHello() {
        System.out.println("调用了打招呼函数" + this.name + this.sex);
        return "hello";
    }

    public static void walkToHome(){
        System.out.println("i walk home");
    }
}

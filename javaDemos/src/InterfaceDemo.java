public class InterfaceDemo {

    public void test1(){

    }
}

class MyDog implements AnimationCommonAction{
    String name;
    @Override
    public void eat() {
        System.out.println(name + "实现了接口" + age);
    }
}
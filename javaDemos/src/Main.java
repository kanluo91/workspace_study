import javax.xml.stream.events.Characters;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        System.out.println("my first java demo s");

        Persion p = new Persion("张三",18);
        p.sex = "男";
        p.sayHello();

        Persion.walkToHome();

        char a = 'a';
        System.out.println(Character.BYTES);


        /// 多线程
        TheadDemo td = new TheadDemo();
        td.thread_1();

    }
}
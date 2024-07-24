public class TheadDemo {

    public void thread_1(){

        Thread t1 = new Thread(Main::print);
        Thread t2 = new Thread(Main::print);
        t1.start();
        t2.start();
    }

    public static void print(){
        System.out.println("调用了线程的函数");
    }


}

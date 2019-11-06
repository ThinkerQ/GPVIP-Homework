package edu.thread;

/**
 * 演示线程声明周期状态
 * 通过jps工具
 */
public class ThreadStatusDemo {
    public static void main(String[] args) {
        new Thread(()->{
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Time_waiting_thread").start();

        //waiting状态
        new Thread(() -> {
            try {
                //wait方法必须在synchrozied临界区内才有效，否则报错
                synchronized (ThreadStatusDemo.class) {
                    ThreadStatusDemo.class.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"waiting_thread").start();


        // blocked状态
        ThreadStatusDemo threadStatusDemo = new ThreadStatusDemo();
        new Thread(()-> threadStatusDemo.method(),"thread-1").start();
        new Thread(()-> threadStatusDemo.method(),"thread-2").start();
        Thread thread3 = new Thread(() -> threadStatusDemo.method(), "thread-3");
    }

    private synchronized void method(){
        while (true);
    }
}

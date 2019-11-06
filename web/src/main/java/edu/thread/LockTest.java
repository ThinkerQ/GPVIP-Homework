package edu.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * lock锁用法
 */
public class LockTest extends Thread{
    private static ReentrantLock lock = new ReentrantLock();

    private void tryLock(){
        System.out.println(Thread.currentThread().getName() + "尝试获得锁");
        if (lock.tryLock()){
            try {
                Thread.sleep(1);
                System.out.println(Thread.currentThread().getName() + "获得了锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName()+"==解锁==");
                lock.unlock();
            }
        }else{
            System.out.println(Thread.currentThread().getName()+"==锁被占用获取不了，等会吧==");
        }
    }

    private void sygn(){
        try {
            System.out.println("尝试获取锁。。。");
            //获取锁，如果获取不到，则当前线程阻塞休眠直到获取到锁
            lock.lock();
            System.out.println("获取锁成功");
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("已解锁====");
            //释放锁
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
//                new LockTest().sygn();
                new LockTest().tryLock();
            }).start();
        }

        new Thread(new LockTest()).start();


    }
}

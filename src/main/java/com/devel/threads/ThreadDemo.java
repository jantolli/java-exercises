package com.devel.threads;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Consumer implements Runnable {

    BlockingQueue<Integer> stack = null;

    public Consumer(BlockingQueue<Integer> stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (stack) {
                    while (stack.isEmpty()) {
                        stack.wait();
                    }
                    System.out.println("Removing " + stack.remove());
                    stack.notify();
                }
                Thread.sleep(new Random(System.currentTimeMillis()).nextInt(3000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Producer implements Runnable {

    BlockingQueue<Integer> stack = null;

    public Producer(BlockingQueue<Integer> stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (stack) {
                    while (stack.remainingCapacity() == 0) {
                        stack.wait();
                    }
                    int value = new Random(System.currentTimeMillis()).nextInt(200);
                    System.out.println("Adding " + value);
                    stack.add(value);
                    stack.notify();
                }
                Thread.sleep(new Random(System.currentTimeMillis()).nextInt(3000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadDemo {

    static BlockingQueue<Integer> stack = new ArrayBlockingQueue<Integer>(6);

    public static void main(String[] args) {
        Thread producer = new Thread(new Producer(stack));
        Thread consumer = new Thread(new Consumer(stack));

        producer.start();
        consumer.start();
    }
}

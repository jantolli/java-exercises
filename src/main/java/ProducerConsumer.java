import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Consumer2 implements Runnable {

    BlockingQueue<Integer> stack = null;

    public Consumer2(BlockingQueue<Integer> stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        try {
            while (true) {
                this.consume();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void consume() throws InterruptedException {
        synchronized (stack) {
            while (stack.isEmpty()) {
                System.out.println("Trying to consume ... Stack size " + stack.size());
                stack.wait();
            }
            System.out.println("Removing from stack " + stack.remove());
            stack.notify();
            // Thread.sleep(new Random(System.currentTimeMillis()).nextInt(3000));
        }
        // If we want a more randomized behaviour set the timer here to the same boundary as the Producer
        Thread.sleep(new Random(System.currentTimeMillis()).nextInt(2000));
    }
}

class Producer2 implements Runnable {

    BlockingQueue<Integer> stack = null;

    public Producer2(BlockingQueue<Integer> stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        try {
            while (true) {
                this.produce(new Random(System.currentTimeMillis()).nextInt(20));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void produce(int value) throws InterruptedException {
        synchronized (stack) {
            while (stack.remainingCapacity() == 0) {
                System.out.println("Trying to add ... Stack size " + stack.size());
                stack.wait();
            }
            System.out.println("Adding " + value);
            stack.add(value);
            stack.notify();
            // If sleep is set here we are not only sleeping this thread but also not releasing the lock.
            // Thus both threads end up waiting and causing very likely the same thread to reacquire the lock.
            // Thread.sleep(new Random(System.currentTimeMillis()).nextInt(2000));
        }
        // Setting the sleep here after releasing the lock creates a more random effect.
        // Since the sleep timer is larger on the Consumer we will see pretty much always the Producer waiting on the Consumer
        // We will see a message always on the Producer trying to add but the stack is full
        Thread.sleep(new Random(System.currentTimeMillis()).nextInt(20));
    }

}

public class ProducerConsumer {

    static BlockingQueue<Integer> stack = new ArrayBlockingQueue<Integer>(2);

    public static void main(String[] args) {
        Thread producer = new Thread(new Producer2(stack));
        Thread consumer = new Thread(new Consumer2(stack));

        producer.start();
        consumer.start();
    }
}

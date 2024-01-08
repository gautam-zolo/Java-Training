package gautam.ProdCon;

import java.util.*;
import java.lang.*;
import java.text.*;

public class Prodcon {
    private static int[] buffer;
    private static int count;

    private static Object obj = new Object();

    static class Producer {
        void produce() {
            synchronized (obj) {
                while (isFull(buffer)) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                buffer[count++] = 1;
                obj.notifyAll();
            }
        }
    }

    static class Consumer {
        void consume() {
            synchronized (obj) {
                while (isEmpty(buffer)) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                buffer[--count] = 0;
                obj.notifyAll();
            }
        }
    }

    private static boolean isFull(int[] buffer) {
        return count == buffer.length;
    }

    private static boolean isEmpty(int[] buffer) {
        return count == 0;
    }

    public static void main(String[] args) throws InterruptedException {
        buffer = new int[10];
        count = 0;

        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        Runnable produceTask = () ->{
            for(int i=0; i<50; i++){
                producer.produce();
            }
            System.out.println("Done Producing");
        };
        Runnable consumeTask = () ->{
            for(int i=0; i<50; i++){
                consumer.consume();
            }
            System.out.println("Done Consuming");
        };

        Thread proThread = new Thread(produceTask);
        Thread conThread = new Thread(consumeTask);

        conThread.start();
        proThread.start();

        conThread.join();
        proThread.join();

        System.out.println("Data in the buffer: "+ count);
    }
}

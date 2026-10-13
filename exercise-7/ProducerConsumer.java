import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    private static final Queue<Integer> BUFFER = new LinkedList<>();
    private static final int CAPACITY = 3;

    private static synchronized void produce(int value) throws InterruptedException {
        while (BUFFER.size() == CAPACITY) ProducerConsumer.class.wait();
        BUFFER.add(value); System.out.println("Produced: " + value); ProducerConsumer.class.notifyAll();
    }
    private static synchronized int consume() throws InterruptedException {
        while (BUFFER.isEmpty()) ProducerConsumer.class.wait();
        int value = BUFFER.remove(); System.out.println("Consumed: " + value); ProducerConsumer.class.notifyAll(); return value;
    }
    public static void main(String[] args) throws InterruptedException {
        Thread producer = new Thread(() -> { try { for (int i=1;i<=10;i++) produce(i); } catch (InterruptedException e) { Thread.currentThread().interrupt(); } });
        Thread consumer = new Thread(() -> { try { for (int i=1;i<=10;i++) consume(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); } });
        producer.start(); consumer.start(); producer.join(); consumer.join();
    }
}

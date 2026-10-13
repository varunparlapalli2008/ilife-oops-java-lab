class MessageThread extends Thread {
    private final String message;
    private final long delay;
    MessageThread(String message, long delay) { this.message = message; this.delay = delay; }
    public void run() {
        try {
            for (int i = 0; i < 5; i++) { System.out.println(message); Thread.sleep(delay); }
        } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}

class MessageTask implements Runnable {
    private final String message;
    private final long delay;
    MessageTask(String message, long delay) { this.message = message; this.delay = delay; }
    public void run() {
        try {
            for (int i = 0; i < 5; i++) { System.out.println(message); Thread.sleep(delay); }
        } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}

public class ThreadMessages {
    public static void main(String[] args) throws InterruptedException {
        Thread[] extended = { new MessageThread("Good Morning", 1000), new MessageThread("Hello", 2000), new MessageThread("Welcome", 3000) };
        for (Thread t : extended) t.start();
        for (Thread t : extended) t.join();
        System.out.println("Runnable implementation:");
        Thread[] runnable = { new Thread(new MessageTask("Good Morning", 1000)), new Thread(new MessageTask("Hello", 2000)), new Thread(new MessageTask("Welcome", 3000)) };
        for (Thread t : runnable) t.start();
        for (Thread t : runnable) t.join();
    }
}

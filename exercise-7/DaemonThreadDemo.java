public class DaemonThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread daemon = new Thread(() -> {
            int count = 1;
            while (true) {
                System.out.println("Daemon task " + count++);
                try { Thread.sleep(200); } catch (InterruptedException e) { return; }
            }
        });
        daemon.setDaemon(true);
        daemon.start();
        Thread.sleep(700);
        System.out.println("Main thread ends; daemon stops automatically.");
    }
}

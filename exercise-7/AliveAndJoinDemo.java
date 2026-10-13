public class AliveAndJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Worker step " + i);
                try { Thread.sleep(300); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }
        });
        System.out.println("Alive before start: " + worker.isAlive());
        worker.start();
        System.out.println("Alive after start: " + worker.isAlive());
        worker.join();
        System.out.println("Alive after join: " + worker.isAlive());
    }
}

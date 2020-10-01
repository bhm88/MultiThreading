package BasicExamples;

public class ThreadCoordination {
    public static void main(String[] args) {
        Thread t = new Thread(new BlockingTask());
        t.start();
        t.interrupt();
    }
    private static class BlockingTask implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                System.out.println("exiting blocking thread");
            }
        }
    }
}

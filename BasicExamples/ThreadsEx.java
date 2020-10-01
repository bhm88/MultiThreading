package BasicExamples;

public class ThreadsEx {
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("we are now in thread " + Thread.currentThread().getName());
                System.out.println("priority of thread is " + Thread.currentThread().getPriority());
            }
        });
        t.setName("first worker thread");
        t.setPriority(Thread.MAX_PRIORITY);
        System.out.println("we are now in thread " + Thread.currentThread().getName() + "before starting a thread");
        t.start();
        System.out.println("we are now in thread " + Thread.currentThread().getName() + "after starting a thread");
        Thread.sleep(10000);
    }
}

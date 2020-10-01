package BasicExamples;

public class UncaughtExceptionEx {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("intentional exception");
            }
        });
        t.setName("misbehavinng thread");
        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("a critical error happened in thread " + t.getName()
                        + "error is " + e.getMessage());
            }
        });
        t.start();
    }
}

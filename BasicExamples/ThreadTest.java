package BasicExamples;

public class ThreadTest {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();
    }

    private static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("we are now in thread " + Thread.currentThread().getName());
            //here we can use this keyword to get all threads methods,here this points to current thread only
            System.out.println(this.getName());
            System.out.println(this.getPriority());

        }

    }
}

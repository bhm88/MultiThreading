package BasicExamples;

import com.sun.javafx.css.converters.ShapeConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Passwordhackprogram {
    public static final int MAX_PWD = 9999;

    public static void main(String[] args) {

        Random random = new Random();
        Vault vault = new Vault(random.nextInt(MAX_PWD));
        List<Thread> threads = new ArrayList<>();
        threads.add(new Ascendinghackerthread(vault));
        threads.add(new Descendinghackerthread(vault));
        threads.add(new PoliceThread());
        for (Thread t : threads) {
            t.start();
        }

    }

    private static class Vault {
        private int password;

        public Vault(int password) {
            this.password = password;
        }

        public boolean isCorrect(int guess) {

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return this.password == guess;
        }
    }

    private static abstract class HackerThread extends Thread {
        protected Vault vault;

        public HackerThread(Vault vault) {
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public synchronized void start() {
            System.out.println("starting thread " + this.getName());
            super.start();
        }
    }

    private static class Ascendinghackerthread extends HackerThread {
        public Ascendinghackerthread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for (int guess = 0; guess < MAX_PWD; guess++) {
                if (vault.isCorrect(guess)) {
                    System.out.println(this.getName() + " guessed the password " + guess);
                    System.exit(0);
                }
            }
        }
    }

    private static class Descendinghackerthread extends HackerThread {
        public Descendinghackerthread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for (int guess = MAX_PWD; guess > 0; guess--) {
                if (vault.isCorrect(guess)) {
                    System.out.println(this.getName() + " guessed the password " + guess);
                    System.exit(0);
                }
            }
        }
    }

    private static class PoliceThread extends Thread {
        @Override
        public void run() {
            for (int i = 10; i > 0; i--) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
            System.out.println("game over ");
            System.exit(0);
        }
    }

}

package BasicExamples;

import java.math.BigInteger;

public class ThreadCoordinationLongComp {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new LongComputationtask(new BigInteger("200000"), new BigInteger("1000000")));
        //by setting setdeamon as true appliation will terminate
        t.setDaemon(true);
        t.start();
        t.sleep(100);
        t.interrupt();
    }

    private static class LongComputationtask implements Runnable {
        private BigInteger base;
        private BigInteger power;

        public LongComputationtask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base + "^" + power + "=" + pow(base, power));

        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger res = BigInteger.ONE;
            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("prematurely interupted computation");
                    return BigInteger.ZERO;
                }
                res = res.multiply(base);
            }
            return res;
        }
    }
}

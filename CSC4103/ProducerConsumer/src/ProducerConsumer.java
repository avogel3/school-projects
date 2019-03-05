import java.util.Vector;

/**
 * Created by avogel on 3/6/16.
 */
public class ProducerConsumer {
    public static void main(String[] args) {

        int numProducers, numConsumers, bufferSize, total;
        if (args.length > 0) {
            try {
                numProducers = Integer.parseInt(args[0]);
                numConsumers = Integer.parseInt(args[1]);
                bufferSize = Integer.parseInt(args[2]);
                total = Integer.parseInt(args[3]);

                Vector buffer = new Vector<Integer>(bufferSize);

                Producer theProducer = new Producer(buffer, numProducers, total);
                Consumer theConsumer = new Consumer(buffer, numConsumers, total);

                Thread prod =  new Thread(theProducer);
                Thread con = new Thread(theConsumer);

                prod.start();
                con.start();

            } catch (NumberFormatException e) {
                System.err.println("There was an error with one of your args: " + args[0] + ", " + args[1] + ", " + args[2] + ", " + args[3]);
                System.exit(1);
            }
        }

    }
}

class Consumer implements Runnable {
    public static int numConsumed = 0;
    private static Vector theBuffer;
    private int totalConsumers;
    private int numGenerate;
    public Consumer(Vector b, int c, int n) {
        theBuffer = b;
        totalConsumers = c;
        numGenerate = n;
    }
    @Override
    public void run() {
        while (true) {
            try {
                for(int i = 0; i < totalConsumers; i++ ) {
                    System.out.println("Consumer Thread: " + i + ", Entry: " + consume());
                    numConsumed++;
                    System.out.println("Number Consumed: " + numConsumed);
                    if(numGenerate == numConsumed) {
                        System.out.println("--------------------------------------------------------------");
                        System.out.println("Total Number Consumed: " + numConsumed);
                        System.out.println("Total Number Produced: " + Producer.numProduced);
                        System.exit(0);
                    }
                    else {
                        Thread.sleep(1);
                    }
                }
            } catch (InterruptedException e) { System.exit(0); }
        }
    }

    private int consume() throws InterruptedException {
        while(numConsumed < numGenerate) {
            while (theBuffer.isEmpty()) {
                synchronized (theBuffer) {
                    theBuffer.wait();
                }
            }
            synchronized (theBuffer) {
                theBuffer.notifyAll();
                return (Integer) theBuffer.remove(0);
            }
        }
        return -1;
    }
}

class Producer implements Runnable {
    private static Vector theBuffer;
    private int totalProducers;
    private int numGenerate;
    public static int numProduced = 0;
    public Producer(Vector b, int c, int n) {
        theBuffer = b;
        totalProducers = c;
        numGenerate = n;
    }
    @Override
    public void run() {
        // while the number of threads produced is less than the current count
        while(numProduced < numGenerate) {
            for (int i = 0; i < totalProducers; i++) {
                numProduced++;
                System.out.println("Number Produced: "+ numProduced);
                int bufferEntry = (int) (Math.random() * 50 + 1);
                System.out.println("Producer Thread: " + i + ", Entry: " + bufferEntry);
                try {
                    produce(bufferEntry);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void produce(int i) throws InterruptedException {
        while (theBuffer.size() == totalProducers) {
            synchronized (theBuffer) {
                theBuffer.wait();
            }
        }
        synchronized (theBuffer) {
            theBuffer.add(new Integer(i));
            theBuffer.notifyAll();
        }
    }
    }

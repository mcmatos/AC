package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;

/**
 * Produces and stores integers into a blocking queue
 */
public class Producer implements Runnable {

    private final BQueue<Apple> queue;
    private int elementNum;

    /**
     * @param queue      the blocking queue to add elements to
     * @param elementNum the number of elements to produce
     */
    public Producer(BQueue queue, int elementNum) {
        this.queue = queue;
        this.elementNum = elementNum;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep((long) (Math.random() * 100));
                if (queue.getSize() >= queue.getLimit())
                    continue;

                queue.offer(new Apple());
                System.out.println(Thread.currentThread().getName() + " produced an apple.\nSize: "
                        + queue.getSize());
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

}

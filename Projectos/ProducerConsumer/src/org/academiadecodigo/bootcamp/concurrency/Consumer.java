package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;

/**
 * Consumer of integers from a blocking queue
 */
public class Consumer implements Runnable {

    private final BQueue<Apple> queue;
    private int elementNum;

    /**
     * @param queue      the blocking queue to consume elements from
     * @param elementNum the number of elements to consume
     */
    public Consumer(BQueue queue, int elementNum) {
        this.queue = queue;
        this.elementNum = elementNum;
    }

    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep((long) (Math.random() * 100));
                if (queue.getSize() <= 0)
                    continue;
                queue.poll();
                System.out.println(Thread.currentThread().getName() + " consumed an apple.\nSize: "
                        + queue.getSize());
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }

        }

    }

}

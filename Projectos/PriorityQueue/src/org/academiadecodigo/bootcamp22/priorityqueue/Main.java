package org.academiadecodigo.bootcamp22.priorityqueue;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        PriorityQueue<Task> taskQueue = new PriorityQueue<>();

        taskQueue.add(new Task(Importance.HIGH, 3));
        taskQueue.add(new Task(Importance.LOW, 2));
        taskQueue.add(new Task(Importance.MEDIUM, 3));
        taskQueue.add(new Task(Importance.LOW, 3));
        taskQueue.add(new Task(Importance.MEDIUM, 1));
        taskQueue.add(new Task(Importance.HIGH, 2));

        while (taskQueue.size() > 0) {

            Task h = taskQueue.poll();
            System.out.println(h.getImportance() + " " + h.getPriority());
        }
    }
}

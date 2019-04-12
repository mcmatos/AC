package org.academiadecodigo.bootcamp22.priorityqueue;


public class Task implements Comparable<Task> {

    private Importance importance;

    private int priority;

    public Task(Importance importance, int priority) {

        this.importance = importance;
        this.priority = priority;
    }

    public int importanceToNum() {

        switch (importance) {
            case LOW:
                return 3;
            case MEDIUM:
                return 2;
            case HIGH:
                return 1;
        }
        return 0;
    }

    @Override
    public int compareTo(Task o) {

        if (this.importanceToNum() > o.importanceToNum())
            return 1;

        if (this.importanceToNum() < o.importanceToNum())
            return -1;

        if (this.priority > o.priority)
            return 1;

        if (this.priority < o.priority)
            return -1;

        return 0;
    }

    public int getPriority() {
        return priority;
    }

    public Importance getImportance() {
        return importance;
    }
}

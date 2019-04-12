package org.academiadecodigo.bootcamp.containers;

public class LinkedList {

    private Node head;
    private int length = 0;

    public LinkedList() {
        this.head = new Node(null);
    }

    public int size() {
        return length;
    }

    /**
     * Adds an element to the end of the list
     *
     * @param data the element to add
     */
    public void add(Object data) {

        Node node = new Node(data);
        Node iterator = head;
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        length++;

    }

    /**
     * Obtains an element by index
     *
     * @param index the index of the element
     * @return the element
     */
    public Object get(int index) {

        if (index >= length || index < 0) {
            return null;
        }
        Node iterator = head;
        int counter = 0;
        while (iterator.getNext() != null) {

            iterator = iterator.getNext();
            if (index == counter) {

                return iterator.getData();
            }
            counter++;
        }
        return null;
    }

    /**
     * Returns the index of the element in the list
     *
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element
     */
    public int indexOf(Object data) {

        Node iterator = head;
        int counter = 0;
        while (iterator.getNext() != null) {

            iterator = iterator.getNext();
            if (data == iterator.getData()) {

                return counter;
            }
            counter++;
        }
        return -1;
    }


    /**
     * Removes an element from the list
     *
     * @param data the element to remove
     * @return true if element was removed
     */
    public boolean remove(Object data) {

       /* Node iterator = head;
        Node previousNode;
        while (iterator.getNext() != null) {

            previousNode = iterator;
            iterator = iterator.getNext();
            if (iterator.getNext() == null) {

                System.out.println("a");
                iterator.setNext(null);
                return true;
            }

            if (data == iterator.getData()) {

                if (previousNode == head) {
                    this.head = null;
                    return true;
                }

                previousNode.setNext(null);
                return true;
            }
        }
        return false;
    }*/

      /*if (indexOf(data) == -1) {
          return false;
      }

        Node iterator = head;
        Node previousNode = null;
        boolean removed = false;



        while (iterator.getNext() != null) {


            previousNode = iterator;
            iterator = iterator.getNext();

            if (iterator.getData() == data) {

                head = iterator.getNext();
                removed = true;
            }

            if (iterator.getData() == data) {

                System.out.println("a");
                previousNode.setNext(iterator.getNext());
                removed = true;
            }
            System.out.println("b");
        }
        return removed;
    }*/
       /* Node beforeRemovedNode = head;
        Node toBeRemoved = beforeRemovedNode.getNext();

        while ()*/
        return false;
    }

    private class Node {

        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            next = null;
        }


        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}



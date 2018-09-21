/**
 * A Linked List will have the following operations:
 * 1. Insert at a position
 * 2. Deletion at a position
 * 3. Length of the Linked List
 * 4. Delete the entire Linked List
 */
package com.company;

import java.util.List;

public class LinkedList<T> {

    private T data;
    private LinkedList<T> next;

    LinkedList(T data) {
        this.data = data;
        this.next = null;
    }

    LinkedList(T data, LinkedList<T> next) {
        this.data = data;
        this.next = next;
    }


    /**
     * insert with no position. i.e. move till the end and insert the element
     * @param data
     * @return
     */
    public T insert(T data) {
        LinkedList<T> temp = this;
        LinkedList<T> prev = null;

        // Loop until we hit the end
        while(temp != null) {
            prev = temp;
            temp = temp.next;
        }

        // create a new node
        LinkedList<T> newEle = new LinkedList<>(data);

        prev.next = newEle;

        return data;
    }


    /**
     * Insert data element a index posiition
     * @param data
     * @param position
     * @return
     */
    public T insert(T data, int position) {
        LinkedList<T> temp = this;
        LinkedList<T> prev = null;
        int counter = 1;

        while(temp != null && counter < position) {
            prev = temp;
            temp = temp.next;
            counter++;
        }

        if(counter < position) {
            return null;
        }

        if (prev != null) { // If the position is not 1, then prev will be null
            LinkedList<T> newEle = new LinkedList<>(data);
            newEle.next = temp;
            prev.next = newEle;
        } else {
            LinkedList<T> existingLink = new LinkedList<>(this.data, this.next);
            this.data = data;
            this.next = existingLink;
        }
        return data;
    }

    /**
     * Delete last element present in the list
     * @return
     */
    public T delete() {
        LinkedList<T> temp = this;
        LinkedList<T> prev = null;

        while(temp.next != null) {
            prev = temp;
            temp = temp.next;
        }

        if(this.next == null) {
            final T removedData = this.data;
            this.data = null;
            return removedData;
        } else {
            final T removedData = temp.data;
            prev.next = null;
            return removedData;
        }
    }

    /**
     * Delete element at a particular position in a linked list
     * @param position
     * @return
     */
    public T delete(int position) {
        LinkedList<T> temp = this;
        LinkedList<T> prev = null;
        int counter = 1;

        while(temp != null && counter < position) {
            prev = temp;
            temp = temp.next;
            counter++;
        }

        if(counter < position) {
            return null;
        }

        if(prev != null) {
            prev.next = temp.next;
            return temp.data;
        } else if(this.next == null) {
            final T removedData = this.data;
            this.data = null;
            return removedData;
        } else {
            final T removedData = this.data;
            this.data = this.next.data;
            this.next = this.next.next;
            return removedData;
        }
    }

    /**
     * Display all the elements of a Linked List
     */
    public void display() {
        LinkedList<T> temp = this;
        while(temp != null) {
            System.out.print(temp.data + "-");
            temp = temp.next;
        }
        System.out.println("");
    }

}

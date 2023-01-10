package com.code.day;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyLinkedList {
    private Node head;
    private Node last;
    private int size;
    ExecutorService executorService = Executors.newCachedThreadPool();

    public MyLinkedList() {
        this.size = 0;
        executorService.shutdown();
    }
    
    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        Node tmp = head;
        for (int i = 0; i < index - 1; i++) {
            tmp = tmp.next;
        }
        return tmp.val;
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
    }
    
    public void addAtTail(int val) {

    }
    
    public void addAtIndex(int index, int val) {

    }
    
    public void deleteAtIndex(int index) {

    }

    private class Node {
        int val;
        Node next;

        Node() {}

        Node(int val) {
            this.val = val;
        }
    }
}
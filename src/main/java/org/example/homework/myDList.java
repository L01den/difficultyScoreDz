package org.example.homework;

public class myDList {
    Node Head;
    Node Tail;

    private class Node{
        int value;
        Node next;
        Node prev;
    }

    public Node push(int pos, int value){
        Node node = new Node();
        node.value = value;

        if(pos == 0){
            if(Head != null){
                node.next = Head;
                Head.prev = node;
            }else{
                Tail = node;
            }
            Head = node;
            return node;
        }

        Node current = Head;
        int index = 0;
        if(current == null){
            Head = node;
        }else{
            while(current.next != null && index < pos - 1){
                current = current.next;
                index++;
            }
            Node next = current.next;
            if(next != null)
                next.prev = node;
            else
                Tail = node;
            current.next = node;
            node.next = next;
            node.prev = current;
        }
        return node;
    }

    public void pop(int pos){
        if(pos == 0){
            if(Head != null){
                Node next = Head.next;
                next.prev = null;
                Head = next;
            }
            return;
        }
        Node current = Head;
        int index = 0;
        while(current.next != null && index < pos - 1){
            current = current.next;
            index++;
        }

        if(current.next.next == null){
            current.next = null;
            Tail = current;
            return;
        }

        Node next = current.next.next;
        current.next = next;
        next.prev = current;
    }

    public void print(){
        Node current = Head;
        while(current != null){
            System.out.printf("%d ", current.value);
            current = current.next;
        }
        System.out.println();
    }

    public void revert(){
        Node current = Head;
        while(current != null){
            Node next = current.next;
            current.next = current.prev;
            current.prev = next;
            current = next;
        }
        Node head = Head;
        Head = Tail;
        Tail = head;
    }
}
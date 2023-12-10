package ru.ssau.tk.labochkimoi.smirnovkondorova.ui;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.TabulatedFunction;

public class FunctionDatabase {
    private Node head;
    private int size;
    public static class Node {
        TabulatedFunction tabulatedFunction;
        Node next;
        Node prev;

        public Node(TabulatedFunction tabulatedFunction)
        {
            this.tabulatedFunction = tabulatedFunction;
        }

        public String toString()
        {
            return (tabulatedFunction.getClass().getSimpleName() + "                       " + tabulatedFunction.getCount() +
                    "                       (" + tabulatedFunction.leftBound() + "; " + tabulatedFunction.rightBound() + ")");
        }
    }
    public void add(TabulatedFunction function) {
        Node newNode = new Node( function);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
        }
        size++;
    }

    public void delete(Node node)
    {
        node.prev.next= node.next;
        node.next.prev = node.prev;
        node = null;
        size--;
    }

    public Node getNode(int index)
    {
       Node search = head;
        if (index < 0) {
            index = size + index;
        }

        index %= size;

        for (int i = 0; i < index; i++) {
            search = search.next;
        }
        return (search);
    }

    public int getSize()
    {
        return size;
    }
}

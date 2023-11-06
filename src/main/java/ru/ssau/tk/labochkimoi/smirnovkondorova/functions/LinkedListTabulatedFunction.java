package ru.ssau.tk.labochkimoi.smirnovkondorova.functions;
import ru.ssau.tk.labochkimoi.smirnovkondorova.exceptions.InterpolationException;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListTabulatedFunction extends AbstractTabulatedFunction implements Cloneable {
    private Node head;

    protected static class Node implements Cloneable {
        public Node next;
        public Node prev;
        public double x;
        public double y;

        Node(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return ("(" + x + "; " + y + "), где " + x + " и " + y + " - абсцисса и ордината точки соответственно.");
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || !(this.getClass() == o.getClass()))
                return false;
            Node other = (Node) o;
            boolean xEquals = (this.x == other.x);
            boolean yEquals = (this.y == other.y);
            return xEquals && yEquals;
        }

        @Override
        public int hashCode() {
            int hashCode = 7 * Double.hashCode(x);
            hashCode = 7 * hashCode + Double.hashCode(y);
            return hashCode;
        }

        @Override
        public Object clone()  {
            return new Node(x, y);
        }
    }

    private void addNode(double x, double y) {
        Node newNode = new Node(x, y);
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
        count++;
    }


    public LinkedListTabulatedFunction(double[] xValues, double[] yValues) throws IllegalArgumentException {
        int length = xValues.length;
        if (length < 2){
            throw new IllegalArgumentException("Длина меньше минимальной");} else {
            checkLengthIsTheSame(xValues, yValues);
            checkSorted(xValues);
            for (int i = 0; i < length; i++)
                addNode(xValues[i], yValues[i]);
        }
    }

    public LinkedListTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) throws IllegalArgumentException {
        if (count<2)
            throw new IllegalArgumentException("Длина меньше минимальной");
        if (xFrom > xTo) {
            double temp = xFrom;
            xFrom = xTo;
            xTo = temp;
        }
        int counter = count - 1;
        double d = (xTo - xFrom) / counter;

        for (int i = 0; i < counter; i++) {
            addNode(xFrom, source.apply(xFrom));
            xFrom += d;
        }
        addNode(xTo, source.apply(xTo));
    }


    private Node getNode(int index) {
        Node search = head;
        if (index < 0) {
            index = count + index;
        }

        index %= count;

        for (int i = 0; i < index; i++) {
            search = search.next;
        }
        return (search);
    }


    protected int floorIndexOfX(double x) throws IllegalArgumentException {
        Node search = head;
        if (x<head.x){
            throw new IllegalArgumentException("x меньше левой границы");
        }
        int index = 0;
        if (search.x < x) {
            while (search.x < x && search.next != head) {
                search = search.next;
                index++;
            }
        }
        return index;
    }


    protected double extrapolateLeft(double x) {
        double leftX = getX(0);
        double rightX = getX(1);
        double leftY = getY(0);
        double rightY = getY(1);

        return interpolate(x, leftX, rightX, leftY, rightY);
    }


    protected double extrapolateRight(double x) {
        double leftX = getX(count - 2);
        double rightX = getX(count - 1);
        double leftY = getY(count - 2);
        double rightY = getY(count - 1);

        return interpolate(x, leftX, rightX, leftY, rightY);
    }


    protected double interpolate(double x, int floorIndex) {
        if (x <= floorIndex && x >= floorIndex - 1){
            double leftX = getX(floorIndex);
            double rightX = getX(floorIndex + 1);
            double leftY = getY(floorIndex);
            double rightY = getY(floorIndex + 1);
            return interpolate(x, leftX, rightX, leftY, rightY);
        } else throw new InterpolationException("X not interval");
    }


    public int getCount() {
        return (count);
    }

    public double getX(int index) {
        return getNode(index).x;
    }


    public double getY(int index) {
        return getNode(index).y;
    }


    public void setY(int index, double value) {
        getNode(index).y = value;
    }


    public int indexOfX(double x) {
        Node search = head;
        int index = 0;
        if (search.x < x) {
            do {
                search = search.next;
                index++;
            } while (search.x != x && search != head);
            if (index == count)
                index = -1;
        }
        return index;
    }

    public int indexOfY(double y) {
        Node search = head;
        int index = 0;
        do {
            search = search.next;
            index++;
        } while (search.y != y && search != head);
        if (index == count)
            index = -1;
        return index;
    }


    public double leftBound() {
        return (head.x);
    }


    public double rightBound() {
        return (head.prev.x);
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        Node counter = head;
        for (int i = 0; i < count; i++) {
            list.append("(").append(counter.x).append("; ").append(counter.y).append(") ");
            counter = counter.next;
        }
        return list.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (!(o instanceof TabulatedFunction))
            return false;
        if (o.getClass()==this.getClass()) {
            LinkedListTabulatedFunction other = (LinkedListTabulatedFunction) o;
            if (other.count != count)
                return false;
            else {
                Node counter1 = head;
                Node counter2 = other.head;
                for (int i = 0; i < count; i++) {
                    if (counter1.x != counter2.x || counter1.y != counter2.y)
                        return false;
                    counter1 = counter1.next;
                    counter2 = counter2.next;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hashCode = 7;
        Node counter = head;
        for (int i = 0; i < count; i++) {
            hashCode = hashCode * 7 + counter.hashCode();
            counter = counter.next;
        }
        return hashCode;
    }

    @Override
    public Object clone() {
        double[] xValues = new double[count];
        double[] yValues = new double[count];

        Node counter = head;
        for (int i = 0; i < count; i++) {
            xValues[i] = counter.x;
            yValues[i] = counter.y;
            counter = counter.next;
        }
        return (new LinkedListTabulatedFunction(xValues, yValues));
    }

    public Iterator<Point> iterator()
    {
        Iterator<Point> iterator = new Iterator<Point>()
        {
            private Node node = head;
            @Override
            public boolean hasNext()
            {

                return (node!=null);
            }

            @Override
            public Point next() throws NoSuchElementException
            {
                if (this.hasNext()) {
                    Point p = new Point(node.x, node.y);
                    if (node==head.prev)
                        node=null;
                    else
                        node = node.next;

                    return p;
                } else
                    throw new NoSuchElementException();
            }
        };
        return iterator;
    }
}
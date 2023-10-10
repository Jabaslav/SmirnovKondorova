package ru.ssau.tk.labochkimoi.smirnovkondorova.functions;

public class LinkedListTabulatedFunction extends AbstractTabulatedFunction {
    Node head;

    private void addNode(double x, double y) {
        Node newNode = new Node();
        newNode.x = x;
        newNode.y = y;
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


    public LinkedListTabulatedFunction(double[] xValues, double[] yValues) {
        int length = xValues.length;
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                addNode(xValues[i], yValues[i]);
            }
        } else head = null;
    }


    public LinkedListTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
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
        if (count > 0) {
            addNode(xTo, source.apply(xTo));
        }
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


    protected int floorIndexOfX(double x) {
        Node search = head;
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
        if (count < 2) {
            return (head.y);
        } else {
            double leftX = getX(0);
            double rightX = getX(1);
            double leftY = getY(0);
            double rightY = getY(1);

            return interpolate(x, leftX, rightX, leftY, rightY);
        }
    }


    protected double extrapolateRight(double x) {
        if (count < 2) {
            return (head.y);
        } else {
            double leftX = getX(count - 2);
            double rightX = getX(count - 1);
            double leftY = getY(count - 2);
            double rightY = getY(count - 1);

            return interpolate(x, leftX, rightX, leftY, rightY);
        }
    }


    protected double interpolate(double x, int floorIndex) {
        if (count < 2) {
            return (head.y);
        } else {
            double leftX = getX(floorIndex);
            double rightX = getX(floorIndex + 1);
            double leftY = getY(floorIndex);
            double rightY = getY(floorIndex + 1);

            return interpolate(x, leftX, rightX, leftY, rightY);
        }
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


}

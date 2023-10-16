package ru.ssau.tk.labochkimoi.smirnovkondorova.functions;


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
        public Node clone() throws CloneNotSupportedException {
            return (Node) super.clone();
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


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (!(o instanceof TabulatedFunction))
            return false;
        if (o instanceof LinkedListTabulatedFunction) {
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
            counter = counter.next;
            hashCode = hashCode*7 + counter.hashCode();
        }
        return hashCode;
    }

    @Override
    public LinkedListTabulatedFunction clone() throws CloneNotSupportedException {
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
}

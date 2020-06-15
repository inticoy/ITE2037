public class Buffer {
    private int loc = 0;
    private double[] data;

    public Buffer(int size) {
        data = new double[size];
    }

    int getSize() {
        return data.length;
    }

    synchronized void add(double toAdd) throws InterruptedException {
        if (loc >= data.length) {
            System.out.println("Buffer is full.");
            wait();
        }
        System.out.println("Adding item " + toAdd);
        System.out.flush();
        data[loc++] = toAdd;
        notifyAll();
    }

    public synchronized double remove() throws InterruptedException {
        if (loc <= 0) {
            System.out.println("Buffer is empty.");
            wait();
        }
        double hold = data[--loc];
        data[loc] = 0.0;
        System.out.println("Removing item " + hold);
        System.out.flush();
        notifyAll();
        return hold;
    }

    public synchronized String toString() {
        String toReturn = "";
        for (int i = 0; i < data.length; i++) {
            toReturn += String.format("%2.2f", data[i] + " ");
        }
        return toReturn;
    }


}

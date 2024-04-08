package SchoolJavaMalkov;

import java.io.*;

public class Counter implements Serializable {
    private int count;

    public Counter() {
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public void increment() {
        count++;
    }

    public void reset() {
        count = 0;
    }

    public void saveState() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("counter.ser"))) {
            out.writeObject(this);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Counter loadState() {
        Counter counter = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("counter.ser"))) {
            counter = (Counter) in.readObject();
        }
        catch (IOException | ClassNotFoundException e ) {
            System.out.println(e.getMessage());
        }
        return counter;
    }
}

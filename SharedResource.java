public class SharedResource {
    private static final Object lock = new Object();
    private static int X = 0;

    public static void incrementX(int value) {
        synchronized (lock) {
            X += value;
        }
    }

    public static int getX() {
        synchronized (lock) {
            return X;
        }
    }
}

class T1 extends Thread {
    public void run() {
        SharedResource.incrementX(3);
    }
}

class T2 extends Thread {
    public void run() {
        SharedResource.incrementX(10);
    }
}

class T3 extends Thread {
    public void run() {
        SharedResource.incrementX(15);
    }
}

// Removed Main class from this file
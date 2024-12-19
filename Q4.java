public class Q4 extends Thread{
    //a) T2, T3 would result in a final value of x=5
    //b)
    private int[] arr;
    private int evenCount = 0;
    private int oddCount = 0;

    public Q4(int[] arr) {
        this.arr = arr;
    }
    public synchronized void incrementer() {
        Thread evenCounter = new Thread(() -> {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 == 0) {
                    evenCount++;
                }
                if (i % 100000 == 0){
                    if(Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread interrupted, "+evenCount+" so far");
                    return;
                }
            }
            }
        });

        Thread oddCounter = new Thread(() -> {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 != 0) {
                    oddCount++;
                }
                if (i % 100000 == 0){
                    if(Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread interrupted, "+oddCount+" so far");
                    return;
                }
            }
            }
        });
        evenCounter.start();
        oddCounter.start();

        try {
            evenCounter.join();
            oddCounter.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[1000000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)Math.random()*100;
        }
        Q4 q4 = new Q4(arr);
        q4.incrementer();
        System.out.println("Even count: " + q4.evenCount);
        System.out.println("Odd count: " + q4.oddCount);
    }
//d)Synchronization of access on the int arr is not neccessary in this case since we only have 2 threads, each with restricted access to either even or odd so therefore we wouldn't have any issues with race conditions since there is only one thread after their own specific type of number (even/odd)


    /* e)synchronization is necessary for these functions because these methods are designed for working with an object's intrinsic lock  which coordinates access to the object's synchronized methods/blocks
the wait method causes the current thread to wait until another thread invoke notify on the same object so the thread releases the lock and enters the waiting state
notify wakes up a singel thread taht is waiting on the object's monitor and the thread can then proceed after reaquiring the intrinsic lock.
*/
    }

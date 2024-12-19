/*public class Main{
    public static void crackPassword(long lower, long upper,  Object systemToCrack){
        CustomBoolean obj = new CustomBoolean(false);
        long rangeSize = (upper - lower)/2;
        long[] range1 = {lower,(lower + rangeSize)};
        long[] range2 = {(lower + rangeSize +1), (upper-rangeSize)};
        long[] range3 = {(upper-rangeSize+1), upper};

        Worker w1 = new Worker(range1[0], range1[1], systemToCrack, obj);
        Thread t1 = new Thread(w1);
        Worker w2 = new Worker(range2[0], range2[1], systemToCrack, obj);
        Thread t2 = new Thread(w2);
        Worker w3 = new Worker(range3[0], range3[1], systemToCrack, obj);
        Thread t3 = new Thread(w3);

        t1.start();
        t2.start();
        t3.start();
        
        while(!obj.get()){}
        t1.interrupt();
        t2.interrupt();
        t3.interrupt();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    public static void main(String[] args){
        Object systemToCrack = new SystemToCrack();
        crackPassword(1000000000L, 7000000000L, systemToCrack);
    }
}
    */

    public class Main {
        public static void main(String[] args) {
            // Create an instance of RestrictedRandomGenerator with bounds 1 and 3
            RestrictedRandomGenerator rr = new RestrictedRandomGenerator(1, 3);
    
            // Test nextRandom method
            int x = rr.nextRandom();
            System.out.println("Random number (1 to 3): " + x); // x can be any of 1, 2, or 3
    
            // Test nextRestrictedRandom method with restricted number 2
            int y = rr.nextRestrictedRandom(2);
            System.out.println("Restricted random number (1 or 3): " + y); // y can be 1 or 3 but not 2
    
            // Additional tests to verify the distribution
            int count1 = 0;
            int count3 = 0;
            for (int i = 0; i < 10000; i++) {
                int z = rr.nextRestrictedRandom(2);
                if (z == 1) {
                    count1++;
                } else if (z == 3) {
                    count3++;
                }
            }
            System.out.println("Count of 1s: " + count1);
            System.out.println("Count of 3s: " + count3);
        }
    }
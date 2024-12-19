public class Worker implements Runnable{
    long lower;
    long upper;
    Object systemToCrack;
    CustomBoolean found;

    public Worker(long lower, long upper, Object systemToCrack, CustomBoolean found) {
        this.lower = lower;
        this.upper = upper;
        this.systemToCrack = systemToCrack;
        this.found = found;
    }

    @Override
    public void run() {
        for(long i=lower;i<upper;i++){
            if(i%1000 == 0){
                if(Thread.currentThread().isInterrupted()){
                    return;
                }
            }
            
            if(systemToCrack.login(i)){
                System.out.println("The password is : "+i);
                found.set(true);
                return;
            }
        }
    }
}
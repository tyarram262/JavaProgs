// Download and place in your own packages

public class MyInt implements Comparable<MyInt> {
    private int x;

    public MyInt(int x){
        this.x = x;
    }

    @Override
    public int compareTo(MyInt arg0) {
        // TODO Auto-generated method stub
        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return 1; // Return does not match 
                      // without clearing interrupt
        }
        return Integer.compare(this.x, arg0.x);
    }


    public String toString(){
        return Integer.toString(this.x);
    }


    //  AEFIS (https://tamu.aefis.net/)

}

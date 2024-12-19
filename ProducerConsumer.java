import java.util.ArrayList;

public class ProducerConsumer extends Thread{
    ArrayList<String> data;

    public ProducerConsumer(String name, ArrayList<String> data){
        setName(name);
        this.data = data;
    }

    public void run(){
        if (Thread.currentThread().getName() == "Producer")
            producer();
        else if (Thread.currentThread().getName() == "ConsumerEven") 
            consumerEven();
        else if (Thread.currentThread().getName() == "ConsumerOdd") 
            consumerEven();
    }

    public void producer(){
        for(int i = 0; i < 100; i++){
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){

            }

            System.out.println("Producing : " + i);
            synchronized(data){
                data.add(Integer.toString(i));
                // System.out.println("Length is : " + data.size());
            }
        }

    }

    public void consumerOdd() {
        while (true) {
            synchronized (data) {
                while (data.isEmpty()) {
                    try {
                        data.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                for (int i = 0; i < data.size(); i++) {
                    if (i % 2 != 0) {
                        System.out.println("Consumed odd: " + data.remove(i));
                        break;
                    }
                }
            }
        }
    }

    public void consumerEven() {
        while (true) {
            synchronized (data) {
                while (data.isEmpty()) {
                    try {
                        data.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                for (int i = 0; i < data.size(); i++) {
                    if (i % 2 == 0) {
                        System.out.println("Consumed even: " + data.remove(i));
                        break;
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        var data = new ArrayList<String>();
        Thread p = new ProducerConsumer("Producer", data);
        Thread c = new ProducerConsumer("ConsumerEven", data);
        Thread c2 = new ProducerConsumer("ConsumerOdd", data);

        p.start();
        c.start();
        c2.start();

        p.join();
        c.join();
        c2.start();

        // Not a good implementation at all

    }
        
}
import java.util.concurrent.ConcurrentLinkedQueue;

public class Reporter extends Thread {
    private ConcurrentLinkedQueue<Response> responses;

    public Reporter(ConcurrentLinkedQueue<Response> responses) {
        this.responses = responses;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (responses) {
                Response response = responses.poll();
                if (response != null) {
                    System.out.println(response.toString());
                }
                if (Thread.currentThread().isInterrupted()) {
                    return;
                }else{
                while (responses.isEmpty()) {
                        try {
                            responses.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
package sparta.week05.thread.join;

public class Main {

    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(task, "thread");

        thread.start();

        long start = System.currentTimeMillis();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("소요시간 = " + (System.currentTimeMillis() - start));
    }

}

package sparta.week05.thread.deamon;

public class Main {

    public static void main(String[] args) {
        Runnable demon = () -> {
            for (int i =0; i<100000; i++) {
                System.out.println("demon");
            }
        };

        // 특징 : 우선 순위가 낮다 . ( 다른 쓰레드에 비해 리소스를 적게 할당받는다 .)

        Thread thread =new Thread(demon);
        thread.setDaemon(true);

        thread.start();

        for (int i = 0; i< 100; i++) {
            System.out.println(i + "번째 =" + "task");

        }
    }

}

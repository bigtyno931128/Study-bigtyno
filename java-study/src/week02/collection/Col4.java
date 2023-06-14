package week02.collection;

import java.util.LinkedList;
import java.util.Queue;

public class Col4 {

    public static void main(String[] args) {
        // Queue : FIFO
        // add , peek , poll
        // Queue : 생성자가 없는 인터페이스

        Queue<Integer> integerQueue = new LinkedList<>(); 
        
        integerQueue.add(5);
        integerQueue.add(6);
        integerQueue.add(7);
        
        while (!integerQueue.isEmpty()) {
            System.out.println("integerQueue.poll() = " + integerQueue.poll());
        }

        integerQueue.add(5);
        integerQueue.add(6);
        integerQueue.add(7);

        System.out.println(integerQueue.peek());
    }

}

package week02.collection;

import java.util.LinkedList;

public class Col2 {

    public static void main(String[] args) {
        // linked List
        // 메모리에 남는 공간을 요청해서 여기 저기 나누어서 실제 값을 담아논다
        // 실제 값이 있는 주소값으로 목록을 구성하고 저장하는 자료구조

        //  ArrayList 와 비교할때 조회 속도는 느리나 값을 추가하거나 삭제할때 용이하다 .

        LinkedList<Integer>linkedList = new LinkedList<Integer>();

        linkedList.add(5);
        linkedList.add(10);
        linkedList.add(15);

        linkedList.add(2,4);

        System.out.println("linkedList.toString() = " + linkedList.toString());

        linkedList.set(1,30);

        System.out.println("linkedList = " + linkedList.toString());
    }

}

package sparta.week02.collection;

import java.util.ArrayList;

public class Col1 {

    public static void main(String[] args) {
        // List 
        // 순서가 있는 데이터의 집합 = > Array ( 최초 길이를 알아야함 ) 
        // 처음에 길이를 몰라도 만들 수 있다 .
        // 1 ) Array - > 정적 배열  , 2) List(ArrayList) --> 동적 배열 ( 크기가 가변적으로 늘어난다 . ) 

        ArrayList<Integer> intList = new ArrayList<>(); 
        
        intList.add(1);
        intList.add(2);
        intList.add(3);

        System.out.println(intList.get(2));

        // 2번째 값 바꾸기

        intList.set(2,10);

        System.out.println(intList.get(2));

        // 삭제 remove

        // 전체 삭제 clear

    }

}

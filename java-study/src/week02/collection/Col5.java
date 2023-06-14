package week02.collection;

import java.util.HashSet;
import java.util.Set;

public class Col5 {

    public static void main(String[] args) {

        //Set (집합) : 순서가 없고 중복이 없다.
        // Set 의 응용 : HashSet , TreeSet
        // Set 은 생성자가 없는 껍데기라서 바로 생성할 수 없다.
        // 생성자가 존재하는 HashSet  이용

        Set<Integer> integerSet = new HashSet<>();

        integerSet.add(1);
        integerSet.add(12);
        integerSet.add(5);
        integerSet.add(1);

        for(Integer value : integerSet) {
            System.out.println("value = " + value);
        }
    }

}

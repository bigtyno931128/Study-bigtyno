package week02.collection;

import java.util.HashMap;
import java.util.Map;

public class Col6 {

    public static void main(String[] args) {
        // map
        // key  , value
        // Map --> HashMap , TreeMap

        Map<String , Integer> integerMap = new HashMap<>();

        integerMap.put("일", 11);
        integerMap.put("이", 11);
        integerMap.put("삼", 11);

        for (String key : integerMap.keySet()) {
            System.out.println(key);
        }
    }

}

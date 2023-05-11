package programmers;

import java.util.HashMap;

public class P위장 {

    public int solution(String[][] clothes) {

        // 매일 다른 옷을 입어야 한다 .
        int answer = 1 ;

        HashMap<String , Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++ ) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1 );

        }

        for (String key : map.keySet()) {
            answer *=(map.get(key)+1);
        }
        answer -=1;
        return answer;
    }

}

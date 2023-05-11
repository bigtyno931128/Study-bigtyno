package programmers;

import java.util.HashMap;

public class P전화번호목록 {

    public boolean solution(String[] phone_book) {

        // phone_book 으로 들어온 값이 하나라도 포함이 되면 false 아니면 true
        // ex ) ["1","2","3"]  = true , ["1","2","12"] = false

        // 1. hashing을 한다 .
        HashMap<String , Integer > map  = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++)
            map.put(phone_book[i], 1);

        // 2. hash 찾기
        for ( int i = 0; i < phone_book.length; i++)
            for( int j = 1; j < phone_book[i].length(); j++)
                if(map.containsKey(phone_book[i].substring(0,j)))
                    return false;

        return true;
    }
}

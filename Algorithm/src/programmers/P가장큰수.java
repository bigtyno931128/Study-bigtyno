package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class P가장큰수 {

    // numbers 의 길이 만큼 for 문을 돌리면서
    // 각 자릿수의 경우의 수로 조합을 한다
    // 솔팅 하고 첫번째 .

    // 길이가 1 일 때 , 큰수로 정렬하면 답
    // 길이가 2 일 때 , [1,2] 12,21  = 21 이 답  , [3,2] 23 32 = 32 가 답
    // 길이가 3 일 때 , [1,2,3] 123,132,213,231,312,321 = 321 이 답
    // 0 만 있는 경우 원소로 0 , 00 , 000
    public String solution(int[] numbers) {

        String[] result = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(result, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {

                return ((o2 + o1).compareTo(o1 + o2));
            }
        });

        // 0만 여러개 있는 배열의 경우 하나의 0만 리턴
        if(result[0].equals("0")) {
            return "0";
        }

        String answer = "";
        // 정렬된 문자 하나로 합치기
        for (String a : result) {
            answer += a;
        }
        return answer;
    }

}

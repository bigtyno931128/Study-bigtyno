package fastcampus.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;

// 단어 공부  --> https://www.acmicpc.net/problem/1157
public class Bj1157 {

    /*
    내 풀이 :  첫째 줄 : 알파벳 대소문자로 이루어진 단어 ( 길이는 :  1,000,000 넘지 않는다.)
    가장 많이 사용된 알파벳을 대문자로 출력 , 2개 이상일때는 ? 출력
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().toUpperCase().split("");
        Arrays.sort(arr);

        int max = 1;
        int min = 1;
        String maxS ="";
        String start = arr[0];
        if (arr.length>1){
            for (int i = 1; i < arr.length; i++) {
                if(start.equals(arr[i])){
                    if (start.equals(arr[0])){
                        min +=1;
                    } else {
                        max += 1;
                        maxS = arr[i];
                    }
                } else {
                    start = arr[i];
                }
            }
            if (max == min) {
                System.out.println("?");
            } else {
                System.out.println(maxS);
            }
        } else {
            System.out.println(arr[0]);
        }
    }
}

package fastcampus.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// 대소문자 바꾸기 - https://www.acmicpc.net/problem/2744

public class Bj2744 {

    /*

    문제. 영어 소문자와 대문자로 이루어진 단어를 입력받은 뒤, 대문자는 소문자로, 소문자는 대문자로 바꾸어 출력하는 프로그램을 작성하시오.
    입력. 첫째 줄에 영어 소문자와 대문자로만 이루어진 단어가 주어진다. 단어의 길이는 최대 100이다.
    출력. 첫째 줄에 입력으로 주어진 단어에서 대문자는 소문자로, 소문자는 대문자로 바꾼 단어를 출력한다.
    시간제한 1초 . 메모리 128 MB

    1. String 을 나눠서 배열에 저장
    2. 반복문
    3. 대문자 시  = > 소문자 , 소문자 시  = > 대문자

    내가 생각한 풀이 법은 받은 알파벳을 놔누어 배열에 저장 -> 반복문 - > 반복문 안에서 arr[i] 의 값이

    String answer = "";

    if (arr[i] <= 'a' && 'z')
        arr[i] = arr[i].toUpperCase()
        answer += arr[i];
    else
        arr[i] = arr[i].toLowerCase()
        answer += arr[i];
    System.out.println(answer);


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] alphabet = br.readLine().split("");
        int[] intArr = new int[alphabet.length];

        for (int i =0 ; i< alphabet.length; i++) {
            alphabet[i].
        }
    }

    */


    /*
        강의 : 아스키 코드를 이용하여 풀이
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ('A' <= ch && ch <= 'Z') {
                ans += (char) ('a' + ch - 'A');
            } else {
                ans += (char) ('A' + ch - 'a');
            }
        }
        System.out.println(ans);
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String st = br.readLine();
//        for (int i = 0; i < st.length(); i++) {
//            // st.charAt(i) 가 대문자 라면 ?
//            char ch = st.charAt(i);
//            if ('A' <= ch && ch >= 'Z') {
//                System.out.print((char) ('a' + ch -'A'));
//            } else {
//                System.out.print((char) ('A' + ch- 'a'));
//            }
//        }
//    }
}

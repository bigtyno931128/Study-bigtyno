package fastcampus.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

// 애너그램 만들기 - https://www.acmicpc.net/problem/1919
public class Bj1919 {

    /*

       문제 : 두 단어를 받아서 두 단어의 알파벳을 비교하여 갯수가 같아져야 하면 이때 같아지기 위해서 문자를 제거 할 수 있다 . 제거해야하는 문자의 최소갯수를 구하자 .
       입력 : 첫째 줄과 둘째 줄에 영어 단어가 소문자로 주어진다. 각각의 길이는 1,000자를 넘지 않으며, 적어도 한 글자로 이루어진 단어가 주어진다.
       출력 : 첫째 줄에 답을 출력한다.

       풀이 : 두 단어를 입력 받고 정렬해서 같은 값 일 경우에만 어떤 값을 증가 시키고 -> 두단어의 str 길이를 합하고 - 어떤값 *2 해주면 안될까?



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));

        String st1 = br.readLine();
//        String st2 = br.readLine();

        int count = 0;

        for (int i = 0; i < st1.length(); i++) {
            char ch = st1.charAt(i);
            count +=1;


        }

    }
    */

    /*
        강의
        입력 받은 두 단어의 공통 된 알파벳을 제외하고 전부 제거 .

     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        // 알파벳의 크기는 26으로 고정되었기에 모든 알파벳을 닮을 수 있는 26의 길이를 가진 배열 을 생성한다면  . char 타입은 아스키코드로 바로 나오기에
        int[] countA = new int[26];
        int[] countB = new int[26];

        for (int i = 0; i < a.length(); i++)
            countA[a.charAt(i) - 'a']++;

        for (int i = 0; i < b.length(); i++)
            countB[b.charAt(i) - 'a']++;

        int result = 0;
        for (int i = 0; i < 26; i++) {
            result +=Math.abs(countA[i]- countB[i]);
        }
        System.out.println(result);
    }
}

package fastcampus.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문서 검색 https://www.acmicpc.net/problem/1543
public class Bj1543 {

    /*
    문제 : 영어로만 이루어진 어떤 문서를 검색하는 함수 . 어떤 단어가 총 몇 번 등장하는지 , 중복 x  세준이는 문서와 검색하려는 단어가 주어졌을 때, 그 단어가 최대 몇 번 중복되지 않게 등장하는지 구하는 프로그램을 작성하시오.
    입력 : 첫째 줄에 문서가 주어진다. 문서의 길이는 최대 2500이다. 둘째 줄에 검색하고 싶은 단어가 주어진다. 이 길이는 최대 50이다. 문서와 단어는 알파벳 소문자와 공백으로 이루어져 있다.
    출력 : 첫째 줄에 중복되지 않게 최대 몇 번 등장하는지 출력한다.

    풀이 :
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().trim();
        String searchStr = br.readLine().trim();

        if (str.length() == searchStr.length()) {
            for (int i = 0; i <str.length(); i ++) {
                if (str.charAt(i) == searchStr.charAt(i)) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
        } else {

            int result = 0;
            int a = 0;

            for (int i = a;  i < str.length(); i++) {
                result +=1;
                if (str.charAt(i) == searchStr.charAt(i)) {
                    a = i ;
                }
            }
            System.out.println(result);
        }


    }
}

package infren;

import java.util.Scanner;

// 숫자의 합 구하기 - https://www.acmicpc.net/problem/11720

public class Bj11720 {

    /*
        문제 : N 개의 숫자가 공백 없이 써 있다 . 이 숫자를 모두 합해 출력
        입력 : 1번째 줄에 숫자의 개수 , 숫자 N 개가 공백없이 주어진다.
        출력 : 입력으로 주어진 숫자 N개의 합 출력
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        String b = sc.next();
        String[] c = b.split("");

        int result = 0;

        if (a == 1) {
            result = a;

        } else {
            for (int i = 0; i <c.length; i++) {
                result += Integer.parseInt(c[i]);
            }
        }

        System.out.println(result);
    }

    // 강의 풀이
    // String 문자열이기 때문에 String 형으로 입력을 받고 .toCharArray 를 이용하여 char[] 으로 변경
    // 아스키 코드를 이용하여 int 형으로 바꿔준뒤 sum 에 추가 .
    // 강의 코드
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        String sNum = sc.next();
//        char[] cNum = sNum.toCharArray();
//        int sum = 0;
//
//        for(int i = 0; i<cNum.length; i ++) {
//            sum += cNum[i] - '0';
//        }
//        System.out.println(sum);
//    }
}

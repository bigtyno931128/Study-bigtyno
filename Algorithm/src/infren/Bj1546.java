package infren;

import java.util.Scanner;

//평균 구하기
public class Bj1546 {


    /*
    내 풀이 : 자기 점수의 최댓 값 M  모든 점수를 점수/M*100
    ex ) 수학이 50 최대 점수가 70 일 경우 50/70*100 = 71.43
    입력 값 | 첫째 과목의 개수 N , 두번째 현재 성적
     */
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int N = sc.nextInt();
//        String a = sc.next();
//        String[] score = a.split(" ");
//
//        int max = 0;
//        int result = 0;
//
//        for (int i = 0; i< score.length; i++) {
//            max = Integer.parseInt(score[i]);
//            for (int j = 1; j< score.length; j++) {
//                if (max >= Integer.parseInt(score[j])) {
//                    max = max;
//                } else {
//                    max = Integer.parseInt(score[j]);
//                }
//            }
//        }
//
//        for (int i = 0; i< score.length; i++ ){
//            result = Integer.parseInt(score[i])/max *100;
//        }
//        System.out.println(result);
//    }

    /*
    강의 풀이 : 각 점수를 더하고 곱하기 100 나누기 최대값 나누기 과목의 개수
    ex ) a,b,c 과목의 경우 (a+b+c) * 100 / max / 3
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for (int i= 0; i<N; i++) {
            A[i] = sc.nextInt();
        }
        long sum = 0;
        long max = 0;

        for (int i = 0; i<N; i++) {
            if(A[i]>max) {
                max = A[i];
            }
            sum = sum + A[i];
        }

        System.out.println(sum*100.0/max/N);
    }
}

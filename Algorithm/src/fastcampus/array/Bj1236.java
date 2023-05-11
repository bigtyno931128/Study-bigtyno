package fastcampus.array;

import java.util.Scanner;

// 성 지키기  : https://www.acmicpc.net/problem/1236
public class Bj1236 {

    // input 1번째 의 1번째가 층을 의미하는것 같고 ==> 행 , 열을 주는듯?
    // 한 줄이 전부다 . 일경우 행 만큼 경비원이 추가 되어야 하는듯
    // 한 행에 x 가 있을경우 x 를 뺴고 세어야하는듯?

    /*
    풀이
    1. 각 행/열에 대해 경비원이 있는지 확인
    2. 보호받지 못하는 행/열의 개수 구하기
    3. 둘 중 큰 값 출력
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] map = new char[N][M];

        for (int i = 0; i < N; i++)
            map[i] = sc.next().toCharArray();

        int existRowCount = 0;
        for (int i = 0; i < N; i++) {
            boolean exist = false;
            for (int j = 0; j< M; j++) {
                if(map[i][j]=='X') {
                    exist = true;
                    break;
                }
                if (exist) existRowCount++;
            }
        }

        int existColCount = 0;
        for (int i = 0; i < N; i++) {
            boolean exist = false;
            for (int j = 0; j< M; j++) {
                if(map[i][j]=='X') {
                    exist = true;
                    break;
                }
                if (exist) existRowCount++;
            }
        }

        int needRowCount = 0;
        int needColCount = 0;
    }
}

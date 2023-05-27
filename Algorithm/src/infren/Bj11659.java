package infren;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//구간 합 구하기 https://www.acmicpc.net/problem/11659
public class Bj11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        // 숫자의 개수
        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        // 질이의 개수
        int quizNo =  Integer.parseInt(stringTokenizer.nextToken());

        long[]S = new long[suNo+1];
        stringTokenizer = new StringTokenizer(br.readLine());

        for (int i = 1; i<=suNo; i++) {
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }
        for (int q = 0; q < quizNo; q++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j]- S[i-1]);
        }
    }
}

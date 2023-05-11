package backjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 더하기 사이클
public class Bj1110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0 ;
        int c = N;
        //
        do {
            N = ((N % 10) * 10) + (((N / 10) + (N % 10)) % 10);
            cnt ++;
        } while (c != N) ;

        System.out.println(c);
    }
}

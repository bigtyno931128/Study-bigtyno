package hackkerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Time_Conversion {
    /*
    문자열로 받은 시간을 24 시간 형태로 바꿔서 출력해주면 되는듯 ?
    AM (오전 ) 12시 1 분은 ==> 00:01:00  PM(오후) 12시 1 분은 ==> 12:01:00

    am 이 12 시인경우 , pm 12시인경우 생각을 해서 분기처리 . am이면서 딱 12시인경우는 00:00:00  12시이면서 다른경우에는 앞에 두자리가 00으로 시작
    pm 의 경우 12시 인경우 그냥 바로 resultTime 을 리턴해주면댐
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String time = br.readLine();
        String resultTime = time.substring(0,8);
        String b = time.substring(8,10);

        int c = Integer.parseInt(time.substring(0,2));

        if(b.equals("AM")) {
            System.out.println(resultTime);
        } else {
            c += 12;
            System.out.println(c+time.substring(2,8));
        }
    }
}

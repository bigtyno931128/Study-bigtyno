package fastcampus.string;

import java.util.Scanner;

public class Bj13223 {

    /*
    소금 폭탄 문제 .
    물컵에 시간이 되면 소금을 집어 넣도록 설계 .
    입력 값 = ( 첫째 줄 = 현재 시각 , 둘째 줄 = 소금 투하 시간 )
    출력 값 = 소금 투하 시간
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String current = sc.next(); // 현재 시각
        String drop = sc.next(); // 투하 시각

        String[] currentUnit = current.split(":");

        int currentHour = Integer.parseInt(currentUnit[0]);
        int currentMinute = Integer.parseInt(currentUnit[1]);
        int currentSecond = Integer.parseInt(currentUnit[2]);

        int currentSecondAmount = currentHour * 3600 + currentMinute * 60 + currentSecond;


        String[] dropUnit = drop.split(":");

        int dropHour = Integer.parseInt(dropUnit[0]);
        int dropMinute = Integer.parseInt(dropUnit[1]);
        int dropSecond = Integer.parseInt(dropUnit[2]);
        int dropSecondAmount = dropHour * 3600 + dropMinute * 60 + dropSecond;

        int needSecondAmount = dropSecondAmount - currentSecondAmount;
        if (needSecondAmount <= 0)
            needSecondAmount += 24 * 3600;

        int needHour = needSecondAmount /3600;
        int needMinute = (needSecondAmount % 3600) / 60 ;
        int needSecond = needSecondAmount % 60;

        System.out.printf("%02d:%02d:%02d",needHour,needMinute,needSecond);
    }
}

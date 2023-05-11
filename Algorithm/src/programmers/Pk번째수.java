package programmers;

import java.util.ArrayList;
import java.util.Arrays;

// 프로그래머스 - k 번째 수
public class Pk번째수 {

    // 런타임 에러
    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] command = new int[commands[i][1] - (commands[i][0] - 1)];
            for (int j = 0; j < command.length; j++) {
                command[j] = array[j + (commands[i][0] - 1)];
            }
            Arrays.sort(command);
            answer[i] = command[commands[i][2] - 1];
        }
        return answer;
    }



}

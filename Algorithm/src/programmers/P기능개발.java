package programmers;

import java.util.*;

public class P기능개발 {

    // 기능은 진도가 100%  --> 서비스
    // 뒤에 기능은 앞에 기능이랑 같이 배포

    // progresses = 작업의 진도  , speeds = 작업의 속도

    // #1  ( 93 -> 1 , 7일 뒤에 100% ) , ( 30 -> 30  4일 ) , ( 55 -> 5 , 9 일 )
    // == > 7일 뒤에 첫 배포 시에는 1,2 기능 o 2번기능 x


    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> q = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < speeds.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int date = (int) Math.ceil(remain);

            if (!q.isEmpty() && q.peek() < date) {
                answerList.add(q.size());
                q.clear();
            }

            q.offer(date);
        }

        answerList.add(q.size());

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}

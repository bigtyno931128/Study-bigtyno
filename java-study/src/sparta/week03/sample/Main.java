package sparta.week03.sample;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("main.getNumber() = " + main.getNumber());
        System.out.println("main.getNumber() = " + main.getNumber());
    }

    public int getNumber() {

        // 지역 변수  : 해당 메서드가 실행될 때 마다 독립적인 값을 저장하고 관리한다 .
        // 이 메서드가 종료될 때 소멸 된다 .
        int number = 1;
        number += 1; // number = number +1
        return number;
    }


}

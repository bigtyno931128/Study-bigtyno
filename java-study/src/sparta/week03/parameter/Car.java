package sparta.week03.parameter;

/*
 1. 만들려고 하는 설계도를 선언
 2. 객체가 가지고 있어야할 속성을 정의
 3. 객체를 생성하는 방식을 정의
 4. 객체가 가지고ㅓ 있어야할 행위를 정의
 */
public class Car {

    String company; // 자동차 회사
    String model = "Gv80"; // 자도창 모델

    String color; // 자동차 색

    double price; // 자동차 가격
    double speed; // 자동차 속도
    char gear; // 기어상태
    boolean lights = true; //자동차 조명의 상태

    Tire tire = new Tire();
    Handle handle;
    Door door;


    //생성자 : 처음 객체가 생성될 때 어떤 로직을 수행하야 하며 , 어떤 값이 필수로 들어와야ㅐ 하는지 정의 !
    public Car() {
    }

    // <메서드 영역 >

    double gasPedal(double kmh, char type) {

        changeGear(type);
        speed= kmh;
        return speed;
    }

    double brakePedal(){
        speed = 0;
        return speed;
    }

    char changeGear(char type) {
        gear = type;
        return gear;
    }

    boolean onOffLights() {
        lights = !lights;
        return lights;
    }

    void horn() {
        System.out.println("빵빵");
    }

    // *** 가변 길이 메서드
    void carSpeeds(double ... speeds) {
        for (double v : speeds) {
            System.out.println("v = " + v);
        }
    }
}

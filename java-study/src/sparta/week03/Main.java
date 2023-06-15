package sparta.week03;

public class Main {

    public static void main(String[] args) {
        
        Car car = new Car(); // 객체 생성 Heap 저장 되겠지 ?

        double speed = car.gasPedal(100, 'D');

        System.out.println("speed = " + speed);

        boolean lights = car.onOffLights();

        System.out.println("lights = " + lights);


    }

}

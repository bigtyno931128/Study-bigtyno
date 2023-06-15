package sparta.week03.abs;

public class Main {

    public static void main(String[] args) {
        Car car1 = new AudiCar();
        car1.horn();
        System.out.println();

        Car car2 = new BenzCar();
        car2.horn();
        System.out.println();

        Car car3 = new ZenesisCar();
        car3.horn();
        System.out.println();
    }

}

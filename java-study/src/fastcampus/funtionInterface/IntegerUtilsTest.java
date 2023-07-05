package fastcampus.funtionInterface;

public class IntegerUtilsTest {

    public static void main(String[] args) {
        Converter<String, Integer> converter = IntegerUtils::stringToInt;
        int result  = converter.converrt("123");
        System.out.println("result =" + result);
    }

}

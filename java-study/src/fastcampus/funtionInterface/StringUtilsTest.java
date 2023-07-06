package fastcampus.funtionInterface;

public class StringUtilsTest {

    public static void main(String[] args) {
        StringUtils stringUtils = new StringUtils();
        Converter<String , String > converter = stringUtils::reverse;
        String result = converter.converrt("hello");
        System.out.println(result);
    }
}

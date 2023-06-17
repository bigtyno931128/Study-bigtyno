package sparta.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Recipe2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String collectionName = sc.next();
        String title = sc.next();

        switch (collectionName) {
            case "List":
                ArrayList<String> strList = new ArrayList<>();
                while (true) {
                    // 한줄씩 입력받아서 strList 에 저장
                    String text = sc.next();
                    if (Objects.equals(text, "끝")) {
                        break;
                    }
                    strList.add(text);
                }

                title = "[ List로 저장된 " + title + " ]";  // [ 제목 ]
                System.out.println(title);
                // strList 한줄씩 출력
                for (int i = 0; i < strList.size(); i++) {
                    int number = i + 1;
                    System.out.println(number + ". " + strList.get(i));
                }
                break;
            case "Set":
                LinkedHashSet<String> strSet = new LinkedHashSet<>();
                while (true) {
                    // 한줄씩 입력받아서 strList 에 저장
                    String text = sc.next();
                    if (Objects.equals(text, "끝")) {
                        break;
                    }
                    strSet.add(text);
                }

                title = "[ Set 으로 저장된 " + title + " ]";  // [ 제목 ]
                System.out.println(title);

                Iterator iterator = strSet.iterator();
                // strList 한줄씩 출력
                for (int i = 0; i < strSet.size(); i++) {
                    int number = i + 1;
                    System.out.println(number + ". " + iterator.next());
                }
                break;
            case "Map":
                Map<Integer, String> strMap = new HashMap<>();
                int lineNumber = 1;
                while (true) {
                    // 한줄씩 입력받아서 strList 에 저장
                    String text = sc.next();
                    if (Objects.equals(text, "끝")) {
                        break;
                    }
                    strMap.put(lineNumber++, text);
                }

                title = "[ Map 으로 저장된 " + title + " ]";  // [ 제목 ]
                System.out.println(title);

                // strList 한줄씩 출력
                for (int i = 0; i < strMap.size(); i++) {
                    int number = i + 1;
                    System.out.println(number + ". " + strMap.get(i + 1));
                }
                break;
            default:
                System.out.println("저장할 수 없는 자료구조 입니다.");
        }
    }
}

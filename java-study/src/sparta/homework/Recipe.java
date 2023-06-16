package sparta.homework;

import java.util.Scanner;

public class Recipe {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        double score = sc.nextDouble();
        String[] recipes = sc.nextLine().split("\\.");


        int realScore = (int)score;

        System.out.println("title = " + "[" + title + "]");
        System.out.println("score = " + "별점 :" + realScore );

        for (int i = 0; i< recipes.length; i++) {
            System.out.println("recipe = " + i + recipes[i]);
        }

    }

}

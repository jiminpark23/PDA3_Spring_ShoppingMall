package exercise.generics;

import java.util.ArrayList;
import java.util.List;

public class ArrayAndListDiff {
    public static void main(String[] args) {
        // 배열(Array) 예시
        int[] intArray = new int[3];
        // intArray[3] = 4;

        String[] strArray = new String[2];
        strArray[0] = "Hello";
        strArray[1] = "World";
        // strArray[2] = "!";

        // 리스트(List) 예시
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);

        List<String> strList = new ArrayList<>();
        strList.add("Hello");
        strList.add("World");
        strList.add("!");


        intList.add(4);
        strList.remove(1);
    }
}

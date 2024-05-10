package exercise.etc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<String> sportStars = new ArrayList<>();

        // add 5개
        sportStars.add("손흥민");
        sportStars.add("김연경");
        sportStars.add("이강인");
        sportStars.add("안산");
        sportStars.add("김연아");

        // 출력
        for (int i=0; i<5; i++) {
            System.out.println(sportStars.get(i));
        }

        // for문 대신 iterator
        Iterator<String> sportStarIterator = sportStars.iterator();
        while(sportStarIterator.hasNext()) {
            System.out.println(sportStarIterator.next());
        }


        // Map
        Map<Integer, String> fruits = new HashMap<>();

        fruits.put(1, "딸기");
        fruits.put(2, "참외");
        fruits.put(3, "귤");
        fruits.put(4, "바나나");
        fruits.put(5, "수박");

        // Map에 있는 순서대로 출력 - for문으로 돌릴 수 없음!
        Iterator<String> fruitsIterator = fruits.values().iterator();
        while(fruitsIterator.hasNext()) {
            System.out.println(fruitsIterator.next());
        }

        // for each문 - 리스트
        for (String sportStar: sportStars) {
            System.out.println(sportStar);

            if (sportStar == "안산") {
                sportStars.remove(sportStar);
            }
        }

//        // for each문 - Map
//        for (String fruit: fruits) {
//            System.out.println(fruit);
//        }

    }
}

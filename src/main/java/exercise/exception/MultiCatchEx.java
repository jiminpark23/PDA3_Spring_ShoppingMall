package exercise.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiCatchEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] cards = {1, 2, 3, 4, 5, 6};

        try {
            System.out.println("몇번째 카드를 뽑으실래요?");
            int cardIdx = scanner.nextInt();    // inputMismatchEx 가능

            System.out.println("뽑은 카드 번호는: " + cardIdx);
            System.out.println("뽑은 카드에 적힌 숫자는: " + cards[cardIdx]); // ArrayIndexOutOfBoundsEx 가능

        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println(e.toString());
            System.out.println("없는 번호입니다");
        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해주세요");
        } catch (Exception e) {
            System.out.println("알 수 없는 에러입니다");
        }

    }
}

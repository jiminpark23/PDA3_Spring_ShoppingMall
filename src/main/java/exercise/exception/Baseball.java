package exercise.exception;

import com.example.shoppingmall.utils.Validator;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Baseball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String answer = generateRandomNumber(random);
        int count = 0;

        while (count < 10) {
            System.out.println("3자리 숫자를 입력해주세요 (ex. 123)");
            String input = scanner.nextLine();

            String[] guess = input.split("");

            try {
                if (Validator.isNumber(Integer.parseInt(input))) {
                    if (guess.length != Arrays.stream(guess).distinct().count()) {
                        System.out.println("중복된 값이 있습니다. 다시 입력해주세요.");
                    }

                    if (guess.length != 3) {
                        System.out.println("3자리 수를 입력해주세요.");
                        continue;
                    }

                    if (Arrays.equals(guess, answer.split(""))) {
                        System.out.println("정답입니다! 축하합니다.");
                        break;
                    }

                    int[] guessInt = new int[guess.length];
                    for (int i = 0; i < guess.length; i++) {
                        guessInt[i] = Integer.parseInt(guess[i]);
                    }

                    int[] answerInt = new int[answer.length()];
                    String[] answerArr = answer.split("");
                    for (int i = 0; i < answerArr.length; i++) {
                        answerInt[i] = Integer.parseInt(answerArr[i]);
                    }

                    int strike = countStrike(guessInt, answerInt);
                    int ball = countBall(guessInt, answerInt);

                    System.out.println("스트라이크: " + strike);
                    System.out.println("볼: " + ball);
                    System.out.println("아웃: " + (3-(strike+ball)));
                }

                count++;
                if (count == 10) {
                    System.out.println("게임 오버");
                    System.out.println("정답은 " + answer + "입니다.");
                    break;
                }
                System.out.println("시도 횟수: " + count);
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            } catch (Exception e) {
                System.out.println("오류가 발생했습니다. 다시 입력해주세요.");
            }
        }
    }

    private static int countStrike(int[] guess, int[] answer) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (guess[i] == answer[i]) {
                strike++;
            }
        }
        return strike;
    }

    private static int countBall(int[] guess, int[] answer) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && guess[i] == answer[j]) {
                    ball++;
                }
            }
        }
        return ball;
    }

    private static String generateRandomNumber(Random random) {
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[10]; // 0부터 9까지의 숫자가 사용되었는지 여부를 저장하는 배열

        // 3자리 숫자 생성
        for (int i = 0; i < 3; i++) {
            int digit;
            do {
                digit = random.nextInt(10); // 0부터 9까지의 난수 생성
            } while (used[digit]); // 이미 사용된 숫자인지 확인

            used[digit] = true; // 해당 숫자를 사용됐음으로 표시
            sb.append(digit); // 숫자를 문자열에 추가
        }
        return sb.toString();
    }

}

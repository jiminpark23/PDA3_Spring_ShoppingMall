package exercise.exception;

import java.util.Scanner;

public class AgeThrowCheckerEx {
    public static void main(String[] args) {
        // 숫자 입력
        // 당신의 나이는 00살이시네요, 반갑습니다.
        Scanner scanner = new Scanner(System.in);
        // 무한루프 -> -1가 들어오면 break;
        // 입력이 범위를 벗어난다면 어떻게 처리?
        while(true) {
            System.out.println("나이를 입력하세요. 범위는 0 ~ 100");

            int age = scanner.nextInt();

            if (age == -1)
                break;

            try {
                if (age < 0 || age > 100) {
                    throw new InputBoundErrorException("0~100 사이로 입력해주세요");
                }
                System.out.println("당신의 나이는 " + age + "살이시네요");
            } catch (InputBoundErrorException e) {
                System.out.println(e.getMessage());
            } finally {
                scanner.close();
            }
        }

    }
}

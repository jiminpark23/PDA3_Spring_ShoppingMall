package exercise.generics;

public class AutoUnboxing {
    public static void main(String[] args) {
        Int num1 = new Int(7);
        System.out.println(num1.i);

        int num2 = 8;
        System.out.println(num2);

        // Deprecated 되어서 이건 쓰지 말죠!
        //Integer num3 = Integer.valueOf(9); // boxing
//        Integer num3 = 9;   // 이제는 boxing도 안 해도 됨
//        System.out.println(num3);   // 한번 객체(Integer)로 감쌌지만, 데이터를 찍어보면 num3으로 그냥 찍어도 9가 나옴 -> AutoUnboxing
    }
}

class Int {
    int i;

    Int(int i) {
        this.i = i;
    }
}

//@Deprecated(since="9", forRemoval = true)
//public void Integer(int value) {
//    this.value = value;
//}
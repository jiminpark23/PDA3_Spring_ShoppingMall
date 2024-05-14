package exercise.etc;

public enum EnumDemo {
    AMERICANO(0, "아메리카노"),
    LATTE(1, "라떼"),
    STRAWBERRY_ADE(2, "딸기에이드"),
    ESPRESSO(3, "에스프레소");

    private final int menuNum;
    private final String menuName;

    EnumDemo(int menuNum, String menuName) {
        this.menuNum = menuNum;
        this.menuName = menuName;
    }

    public void selectMenu() {
        System.out.println(menuName);
    }

    @Override
    public String toString() {
        return "EnumDemo{" +
                "menuNum=" + menuNum +
                ", menuName='" + menuName + '\'' +
                '}';
    }
}


//// 기본
//package exercise.etc;
//
//public class EnumDemo {
//    int menu;
//
//    EnumDemo(int menu) {
//        this.menu = menu;
//    }
//
//    public static final int americano = 0;
//    public static final int latte = 1;
//    public static final int strawberryAde = 2;
//    public static final int espresso = 3;
//
//    public void selectMenu() {
//        switch(menu) {
//            case americano: // 0:
//                System.out.println("아메리카노");
//                break;
//            case latte: // 1:
//                System.out.println("라떼");
//                break;
//            case strawberryAde: // 2:
//                System.out.println("딸기에이드");
//                break;
//            case espresso: // 3:
//                System.out.println("에스프레소");
//                break;
//
//        }
//    }
//}
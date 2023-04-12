public class NumberSystemTester {
    public static void main(String[] args){
        System.out.println(NumberSystem.gcf(30, 3));
        System.out.println(NumberSystem.gcf(3, 30));
        System.out.println(NumberSystem.gcf(24, 9));
        System.out.println(NumberSystem.gcf(7, 3));

        System.out.println();

        NumberSystem.reduceFraction(30, 3);
        NumberSystem.reduceFraction(8, 20);
        NumberSystem.reduceFraction(24, 9);
        NumberSystem.reduceFraction(7, 3);
    }
}

public class MyJVMTest_3503 {

    static int a = 4;

    boolean test_isLtC(int a) {
        return a < 7;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3503().test_isLtC(a));
    }
}

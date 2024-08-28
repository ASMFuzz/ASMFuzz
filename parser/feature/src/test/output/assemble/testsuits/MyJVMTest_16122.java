public class MyJVMTest_16122 {

    static int a = -1511668542;

    boolean test_isEqC(int a) {
        return a == 7;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16122().test_isEqC(a));
    }
}

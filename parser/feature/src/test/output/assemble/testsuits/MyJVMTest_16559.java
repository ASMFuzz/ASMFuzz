public class MyJVMTest_16559 {

    static int a = -2145959614;

    boolean test_isGeC(int a) {
        return a >= 7;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16559().test_isGeC(a));
    }
}

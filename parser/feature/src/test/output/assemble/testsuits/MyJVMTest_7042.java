public class MyJVMTest_7042 {

    static int a = 8;

    boolean test_isGeC(int a) {
        return a >= 7;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7042().test_isGeC(a));
    }
}

public class MyJVMTest_13595 {

    static int a = 977415525;

    static int b = 9;

    int test_shr(int a, int b) {
        return a >> b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13595().test_shr(a, b));
    }
}

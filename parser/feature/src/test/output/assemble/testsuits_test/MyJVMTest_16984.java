public class MyJVMTest_16984 {

    static int a = 0;

    static int b = 0;

    int test_xor(int a, int b) {
        return a ^ b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16984().test_xor(a, b));
    }
}

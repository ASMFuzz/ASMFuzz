public class MyJVMTest_7449 {

    static int a = 0;

    static int b = 653592683;

    int test_xor(int a, int b) {
        return a ^ b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7449().test_xor(a, b));
    }
}

public class MyJVMTest_12677 {

    static int a = 1;

    static int b = 8;

    int test_addi(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12677().test_addi(a, b));
    }
}

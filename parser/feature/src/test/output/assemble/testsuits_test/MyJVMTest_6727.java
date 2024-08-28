public class MyJVMTest_6727 {

    static int a = 2;

    static int b = 0;

    int test_subi(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6727().test_subi(a, b));
    }
}

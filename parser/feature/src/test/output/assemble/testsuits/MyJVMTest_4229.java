public class MyJVMTest_4229 {

    static int a = 74768369;

    static int b = 0;

    int test_shr(int a, int b) {
        return a >> b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4229().test_shr(a, b));
    }
}

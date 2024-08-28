public class MyJVMTest_2632 {

    static int a = 8;

    static int b = 1062733109;

    int test_or(int a, int b) {
        return a | b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2632().test_or(a, b));
    }
}

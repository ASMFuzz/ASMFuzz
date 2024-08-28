public class MyJVMTest_11914 {

    static int a = 3;

    static int b = 0;

    int test_or(int a, int b) {
        return a | b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11914().test_or(a, b));
    }
}

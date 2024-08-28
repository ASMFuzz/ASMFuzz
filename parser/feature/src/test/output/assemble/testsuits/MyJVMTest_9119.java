public class MyJVMTest_9119 {

    static int a = 0;

    static int b = 5;

    static int c = 5;

    int test(int a, int b, int c) {
        return a * b - b * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9119().test(a, b, c));
    }
}

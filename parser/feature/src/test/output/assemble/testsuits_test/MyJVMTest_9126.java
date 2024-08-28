public class MyJVMTest_9126 {

    static int a = -1904540018;

    static int b = 1;

    static int c = 0;

    int test(int a, int b, int c) {
        return a * b - a * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9126().test(a, b, c));
    }
}

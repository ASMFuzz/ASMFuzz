public class MyJVMTest_9931 {

    static int a = 7;

    static int b = 0;

    static int c = 2;

    int test(int a, int b, int c) {
        return a * b + a * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9931().test(a, b, c));
    }
}

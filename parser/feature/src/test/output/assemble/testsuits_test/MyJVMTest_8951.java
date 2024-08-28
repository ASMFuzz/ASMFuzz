public class MyJVMTest_8951 {

    static int a = -831320902;

    static int b = 635499550;

    static int c = 0;

    int test(int a, int b, int c) {
        return a * b + a * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8951().test(a, b, c));
    }
}

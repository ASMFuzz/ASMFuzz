public class MyJVMTest_17380 {

    static int a = 0;

    static int b = 8;

    static int c = -2089669469;

    int test(int a, int b, int c) {
        return a * c + b * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17380().test(a, b, c));
    }
}

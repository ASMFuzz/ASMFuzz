public class MyJVMTest_753 {

    static int a = -187560956;

    static int b = 1018041719;

    static int c = 6;

    int test(int a, int b, int c) {
        return a * b + a * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_753().test(a, b, c));
    }
}

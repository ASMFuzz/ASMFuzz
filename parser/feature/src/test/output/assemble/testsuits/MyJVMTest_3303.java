public class MyJVMTest_3303 {

    static int a = 1;

    static int b = 0;

    static int c = -666311005;

    int test(int a, int b, int c) {
        return a * b - b * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3303().test(a, b, c));
    }
}

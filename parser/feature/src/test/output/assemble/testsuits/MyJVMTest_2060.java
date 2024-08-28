public class MyJVMTest_2060 {

    static int a = 9;

    static int b = 2;

    static int c = 3;

    int test(int a, int b, int c) {
        return a * b + b * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2060().test(a, b, c));
    }
}

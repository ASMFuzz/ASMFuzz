public class MyJVMTest_6869 {

    static int a = -881157665;

    static int b = 4;

    static int c = 0;

    int test(int a, int b, int c) {
        return a * c - b * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6869().test(a, b, c));
    }
}

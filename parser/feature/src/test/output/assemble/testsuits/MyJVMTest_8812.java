public class MyJVMTest_8812 {

    static int a = 9;

    static int b = 4;

    static int c = 2;

    int test(int a, int b, int c) {
        return a * c - b * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8812().test(a, b, c));
    }
}

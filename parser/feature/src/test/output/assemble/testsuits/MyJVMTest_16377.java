public class MyJVMTest_16377 {

    static int a = -379843972;

    static int b = 2;

    static int c = 8;

    int test(int a, int b, int c) {
        return a * c - b * c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16377().test(a, b, c));
    }
}

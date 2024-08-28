public class MyJVMTest_14502 {

    static int a = 0;

    static int b = -885439845;

    int test_ushr(int a, int b) {
        return a >>> b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14502().test_ushr(a, b));
    }
}

public class MyJVMTest_16123 {

    static int a = 0;

    int test_ushrc1(int a) {
        return a >>> 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16123().test_ushrc1(a));
    }
}

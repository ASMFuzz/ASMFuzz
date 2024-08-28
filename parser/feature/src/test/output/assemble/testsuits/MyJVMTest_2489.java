public class MyJVMTest_2489 {

    static int a = -452420926;

    int test_ushrc33(int a) {
        return a >>> 33;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2489().test_ushrc33(a));
    }
}

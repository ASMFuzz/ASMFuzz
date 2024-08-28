public class MyJVMTest_11759 {

    static int a = 1341630214;

    int test_ushrc33(int a) {
        return a >>> 33;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11759().test_ushrc33(a));
    }
}

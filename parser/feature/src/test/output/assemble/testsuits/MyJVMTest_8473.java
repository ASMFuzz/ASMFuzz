public class MyJVMTest_8473 {

    static long a = 1585259849165957912L;

    long test_neg(long a) {
        return -a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8473().test_neg(a));
    }
}

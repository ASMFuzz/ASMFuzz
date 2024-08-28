public class MyJVMTest_7897 {

    static int i = -444441269;

    int test_int_reversed(int i) {
        return Integer.reverseBytes(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7897().test_int_reversed(i));
    }
}

public class MyJVMTest_17459 {

    static int i = 3;

    int test_int_reversed(int i) {
        return Integer.reverseBytes(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17459().test_int_reversed(i));
    }
}

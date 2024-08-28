public class MyJVMTest_4930 {

    static long p = 0;

    static long word_size = -9223372036854775808L;

    boolean isNull() {
        return p == 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4930().isNull());
    }
}

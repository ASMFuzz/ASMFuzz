public class MyJVMTest_8255 {

    static long a = -9223372036854775808L;

    long test_mulc4(long a) {
        return a * 10;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8255().test_mulc4(a));
    }
}

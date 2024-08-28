public class MyJVMTest_4478 {

    static long a = -9223372036854775808L;

    long test_subc1(long a) {
        return a - 11;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4478().test_subc1(a));
    }
}

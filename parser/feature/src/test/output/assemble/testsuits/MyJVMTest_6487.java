public class MyJVMTest_6487 {

    static long a = -9223372036854775808L;

    long test_mulc3(long a) {
        return a * 7;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6487().test_mulc3(a));
    }
}

public class MyJVMTest_17160 {

    static long i = -9223372036854775808L;

    static Long ib = -9223372036854775808L;

    long testp(long i, Long ib) {
        if ((i & 1) == 0)
            ib = new Long(i + 1);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17160().testp(i, ib));
    }
}

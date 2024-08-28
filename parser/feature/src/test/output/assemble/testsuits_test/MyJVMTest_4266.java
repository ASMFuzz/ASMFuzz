public class MyJVMTest_4266 {

    static long i = -9223372036854775808L;

    static Long ibc = new Long(1);

    long testc(long i) {
        Long ib = ibc;
        if ((i & 1) == 0)
            ib = new Long(i + 1);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4266().testc(i));
    }
}

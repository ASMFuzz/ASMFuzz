public class MyJVMTest_16181 {

    static long i = 9223372036854775807L;

    long testm(long i) {
        Long ib = i;
        if ((i & 1) == 0)
            ib = new Long(i + 1);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16181().testm(i));
    }
}

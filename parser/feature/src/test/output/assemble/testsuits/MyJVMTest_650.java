public class MyJVMTest_650 {

    static long i = -9223372036854775808L;

    long testb(long i) {
        Long ib = i;
        if ((i & 1) == 0)
            ib = (i + 1);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_650().testb(i));
    }
}

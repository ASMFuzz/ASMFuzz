public class MyJVMTest_15995 {

    static long i = -9223372036854775808L;

    long test(long i) {
        Long ib = new Long(i);
        if ((i & 1) == 0)
            ib = i + 1;
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15995().test(i));
    }
}

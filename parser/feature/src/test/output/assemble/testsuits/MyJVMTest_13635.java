public class MyJVMTest_13635 {

    static long i = 5092315388268566820L;

    static Long ibc = new Long(1);

    long testc(long i) {
        Long ib = ibc;
        if ((i & 1) == 0)
            ib = new Long(i + 1);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13635().testc(i));
    }
}

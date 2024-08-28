public class MyJVMTest_5316 {

    static long i = 8063570137803697657L;

    static Long ib1 = 0;

    long simplep2(long i, Long ib1) {
        Long ib2 = Long.valueOf(i + 1);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5316().simplep2(i, ib1));
    }
}

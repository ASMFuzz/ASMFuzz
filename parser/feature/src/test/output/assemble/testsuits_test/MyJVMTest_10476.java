public class MyJVMTest_10476 {

    static long i = 6145613470618556931L;

    void dummy() {
    }

    static Long ibc = new Long(1);

    long simplec_deop(long i) {
        Long ib = ibc;
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10476().simplec_deop(i));
    }
}

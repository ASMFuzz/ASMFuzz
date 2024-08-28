public class MyJVMTest_6685 {

    static long i = 0;

    long testm(long i) {
        Long ib = i;
        if ((i & 1) == 0)
            ib = new Long(i + 1);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6685().testm(i));
    }
}

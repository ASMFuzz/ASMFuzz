public class MyJVMTest_13761 {

    static long i = -9223372036854775808L;

    long simple(long i) {
        Long ib = new Long(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13761().simple(i));
    }
}

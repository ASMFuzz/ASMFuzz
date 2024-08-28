public class MyJVMTest_17251 {

    static long i = -9223372036854775808L;

    long test2(long i) {
        Long ib1 = new Long(i);
        Long ib2 = new Long(i + 1);
        if ((i & 1) == 0) {
            ib1 = new Long(i + 1);
            ib2 = new Long(i + 2);
        }
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17251().test2(i));
    }
}

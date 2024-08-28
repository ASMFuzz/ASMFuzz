public class MyJVMTest_6925 {

    static long i = 2156343988879888511L;

    static Long ibc = new Long(1);

    long testc2(long i) {
        Long ib1 = ibc;
        Long ib2 = i + 1;
        if ((i & 1) == 0) {
            ib1 = (ibc + 1);
            ib2 = (i + 2);
        }
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6925().testc2(i));
    }
}

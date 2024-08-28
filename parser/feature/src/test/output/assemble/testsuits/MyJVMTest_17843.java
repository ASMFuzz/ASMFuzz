public class MyJVMTest_17843 {

    static long i = -9223372036854775808L;

    long testb2(long i) {
        Long ib1 = i;
        Long ib2 = i + 1;
        if ((i & 1) == 0) {
            ib1 = (i + 1);
            ib2 = (i + 2);
        }
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17843().testb2(i));
    }
}

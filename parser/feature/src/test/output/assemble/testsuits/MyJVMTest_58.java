public class MyJVMTest_58 {

    static long i = -4401213004003192340L;

    long testm2(long i) {
        Long ib1 = new Long(i);
        Long ib2 = i + 1;
        if ((i & 1) == 0) {
            ib1 = new Long(i + 1);
            ib2 = (i + 2);
        }
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_58().testm2(i));
    }
}

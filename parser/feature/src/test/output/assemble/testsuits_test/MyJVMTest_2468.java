public class MyJVMTest_2468 {

    static long i = 0;

    static Long ibc = new Long(1);

    long simplec2(long i) {
        Long ib1 = ibc;
        Long ib2 = Long.valueOf(i + 1);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2468().simplec2(i));
    }
}

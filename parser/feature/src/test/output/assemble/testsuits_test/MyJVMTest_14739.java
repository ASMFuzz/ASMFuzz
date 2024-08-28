public class MyJVMTest_14739 {

    static long i = 9223372036854775807L;

    static Long ib1 = 7163338132542794981L;

    long simplep2(long i, Long ib1) {
        Long ib2 = Long.valueOf(i + 1);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14739().simplep2(i, ib1));
    }
}

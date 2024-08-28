public class MyJVMTest_2291 {

    static long i = 3517853342302640668L;

    static Long ib1 = 9223372036854775807L;

    long testp2(long i, Long ib1) {
        Long ib2 = i + 1;
        if ((i & 1) == 0) {
            ib1 = new Long(i + 1);
            ib2 = (i + 2);
        }
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2291().testp2(i, ib1));
    }
}

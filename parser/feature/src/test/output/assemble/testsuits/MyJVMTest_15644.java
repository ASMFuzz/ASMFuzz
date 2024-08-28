public class MyJVMTest_15644 {

    static long i = 9223372036854775807L;

    Long foob(long i) {
        return Long.valueOf(i);
    }

    long simplef(long i) {
        Long ib = foob(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15644().simplef(i));
    }
}

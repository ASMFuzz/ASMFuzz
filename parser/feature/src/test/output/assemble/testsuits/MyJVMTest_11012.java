public class MyJVMTest_11012 {

    static long l = -9223372036854775808L;

    int fint(long l) {
        return Long.bitCount(l);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11012().fint(l));
    }
}

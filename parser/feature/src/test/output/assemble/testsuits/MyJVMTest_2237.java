public class MyJVMTest_2237 {

    static long i = -9223372036854775808L;

    long simpleb(long i) {
        Long ib = Long.valueOf(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2237().simpleb(i));
    }
}

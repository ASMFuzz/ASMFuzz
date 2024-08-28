public class MyJVMTest_15591 {

    static long x = 9223372036854775807L;

    static long DIVISOR = 0;

    long fint(long x) {
        return x % DIVISOR;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15591().fint(x));
    }
}

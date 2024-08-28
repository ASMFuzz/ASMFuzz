public class MyJVMTest_6125 {

    static long x = 0;

    static long DIVISOR = 0;

    long fint(long x) {
        return x % DIVISOR;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6125().fint(x));
    }
}

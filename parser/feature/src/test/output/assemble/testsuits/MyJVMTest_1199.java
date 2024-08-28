public class MyJVMTest_1199 {

    static long x = 4036056189421846606L;

    static long DIVISOR = 0;

    long fcomp(long x) {
        return x % DIVISOR;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1199().fcomp(x));
    }
}

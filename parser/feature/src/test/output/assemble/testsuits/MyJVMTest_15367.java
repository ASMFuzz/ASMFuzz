public class MyJVMTest_15367 {

    static long a = 0;

    static long DIVISOR = 0;

    long divcomp(long a) {
        return a / DIVISOR;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15367().divcomp(a));
    }
}

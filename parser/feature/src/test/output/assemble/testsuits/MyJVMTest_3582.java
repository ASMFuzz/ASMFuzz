public class MyJVMTest_3582 {

    static long l = 0;

    int tzcomp(long l) {
        return Long.numberOfTrailingZeros(l);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3582().tzcomp(l));
    }
}

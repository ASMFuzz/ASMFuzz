public class MyJVMTest_293 {

    static long a = 0;

    static long b = 9223372036854775807L;

    long checkMethod(long a, long b) {
        return Math.multiplyExact(a, b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_293().checkMethod(a, b));
    }
}

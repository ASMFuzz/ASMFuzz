public class MyJVMTest_9445 {

    static long a = -5375152420280106769L;

    static long b = 4922797661579387293L;

    long checkMethod(long a, long b) {
        return Math.multiplyExact(a, b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9445().checkMethod(a, b));
    }
}

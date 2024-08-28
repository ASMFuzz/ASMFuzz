public class MyJVMTest_16315 {

    static long y = -801832755567664048L;

    long nextLong() {
        y ^= (y << 13);
        y ^= (y >>> 17);
        return (y ^= (y << 5));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16315().nextLong());
    }
}

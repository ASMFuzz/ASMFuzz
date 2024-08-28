public class MyJVMTest_7205 {

    static XorShift r = new XorShift();

    static long y = 9223372036854775807L;

    long nextLong() {
        y ^= (y << 13);
        y ^= (y >>> 17);
        return (y ^= (y << 5));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7205().nextLong());
    }
}

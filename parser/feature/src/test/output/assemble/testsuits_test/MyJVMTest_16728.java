public class MyJVMTest_16728 {

    static XorShift r = new XorShift();

    static long y = 0;

    long nextLong() {
        y ^= (y << 13);
        y ^= (y >>> 17);
        return (y ^= (y << 5));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16728().nextLong());
    }
}

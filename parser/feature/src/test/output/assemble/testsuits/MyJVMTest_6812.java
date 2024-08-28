public class MyJVMTest_6812 {

    static long y = -3843872815518321648L;

    long nextLong() {
        y ^= (y << 13);
        y ^= (y >>> 17);
        return (y ^= (y << 5));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6812().nextLong());
    }
}

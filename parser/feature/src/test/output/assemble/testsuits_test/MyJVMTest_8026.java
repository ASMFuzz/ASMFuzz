public class MyJVMTest_8026 {

    static boolean b = false;

    static int lo = 547520174;

    static int hi = 6;

    int getNarrowInt(boolean b, int lo, int hi) {
        return b ? lo : hi;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8026().getNarrowInt(b, lo, hi));
    }
}

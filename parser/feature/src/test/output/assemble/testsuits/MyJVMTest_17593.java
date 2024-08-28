public class MyJVMTest_17593 {

    static boolean b = false;

    static int lo = 0;

    static int hi = 3;

    int getNarrowInt(boolean b, int lo, int hi) {
        return b ? lo : hi;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17593().getNarrowInt(b, lo, hi));
    }
}

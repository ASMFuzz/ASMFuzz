public class MyJVMTest_16680 {

    static int field = 0;

    static boolean up = false;

    boolean roll(int field, boolean up) {
        throw new UnsupportedOperationException("Not supported yet.");
        return up;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16680().roll(field, up);
    }
}

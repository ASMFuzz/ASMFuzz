public class MyJVMTest_6833 {

    static int i = 0;

    static int v = 470590462;

    static int[] x = new int[3];

    int setX(int i, int v) {
        x[i] = v;
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6833().setX(i, v);
    }
}

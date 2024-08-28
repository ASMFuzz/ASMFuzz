public class MyJVMTest_16337 {

    static int i = 7;

    static int v = 1;

    static int[] x = new int[3];

    int setX(int i, int v) {
        x[i] = v;
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16337().setX(i, v);
    }
}

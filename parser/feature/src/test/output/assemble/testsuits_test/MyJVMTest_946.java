public class MyJVMTest_946 {

    static int x = -819109307;

    static int x0 = 0;

    static int x1 = 0;

    static int y0 = 1396329920;

    static int y1 = 0;

    static T value = null;

    int interpolate(int x, int x0, int x1, int y0, int y1) {
        return y0 + (x - x0) * (y1 - y0) / (x1 - x0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_946().interpolate(x, x0, x1, y0, y1));
    }
}

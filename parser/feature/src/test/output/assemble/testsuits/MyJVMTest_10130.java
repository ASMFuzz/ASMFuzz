public class MyJVMTest_10130 {

    static int x = -520959010;

    static int x0 = 4;

    static int x1 = -1452746044;

    static int y0 = 0;

    static int y1 = 2059851452;

    static T value = null;

    int interpolate(int x, int x0, int x1, int y0, int y1) {
        return y0 + (x - x0) * (y1 - y0) / (x1 - x0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10130().interpolate(x, x0, x1, y0, y1));
    }
}

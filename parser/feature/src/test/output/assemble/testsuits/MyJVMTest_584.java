public class MyJVMTest_584 {

    static int color = 5;

    static int r = 0;

    static int g = 0;

    static int b = 5;

    static String[] formats = { "png", "jpeg", "tiff", "bmp", "gif" };

    int colorDistance(int color, int r, int g, int b) {
        int r0 = ((color >> 16) & 0xff) - r;
        int g0 = ((color >> 8) & 0xff) - g;
        int b0 = (color & 0xff) - b;
        return r0 * r0 + g0 * g0 + b0 * b0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_584().colorDistance(color, r, g, b));
    }
}

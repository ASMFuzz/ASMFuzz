import java.awt.Color;

public class MyJVMTest_13449 {

    static int n = 773776911;

    static int m = 8;

    static String name1x = ".oZC$%!_c4";

    static String name2x = "$n+#miKZlI";

    static Color color1x = null;

    static Color color2x = null;

    boolean compare(int n, int m) {
        return Math.abs(n - m) <= 50;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13449().compare(n, m));
    }
}

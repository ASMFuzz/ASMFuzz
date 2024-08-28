import java.awt.Color;

public class MyJVMTest_13596 {

    static int n = -1550837234;

    static int m = 0;

    static boolean isMac = false;

    static String name1x = "'~a#PDKRX\"";

    static String name2x = "'9Dr+)Hc{S";

    static Color color1x = null;

    static Color color2x = null;

    boolean compare(int n, int m) {
        return Math.abs(n - m) <= 50;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13596().compare(n, m));
    }
}

import java.awt.Color;

public class MyJVMTest_4090 {

    static int n = 0;

    static int m = 6;

    static String name1x = "1+@nZEO)#>";

    static String name2x = "Cp2!0c!{nS";

    static Color color1x = null;

    static Color color2x = null;

    boolean compare(int n, int m) {
        return Math.abs(n - m) <= 50;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4090().compare(n, m));
    }
}

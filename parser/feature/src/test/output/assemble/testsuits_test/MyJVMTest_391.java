import java.awt.*;

public class MyJVMTest_391 {

    static int index = 7;

    static int minColor = 1;

    static int colorRange = 4;

    static Color[] colors = {null,null,null,null,null,null,null,null,null,null};

    static int rSteps = 1741406796;

    static int gSteps = 2;

    static int bSteps = -1731089160;

    static int totalRange = 3;

    static int rRange = 0;

    static double rStart = Double.MIN_VALUE;

    static double gStart = Double.MAX_VALUE;

    static double bStart = Double.MAX_VALUE;

    Color getColor(int index) {
        return colors[index];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_391().getColor(index));
    }
}

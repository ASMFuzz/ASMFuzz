import java.awt.*;

public class MyJVMTest_9548 {

    static int index = 710587365;

    static int minColor = 4;

    static int colorRange = 709646770;

    static Color[] colors = {null,null,null,null,null,null,null,null,null,null};

    static int rSteps = 1;

    static int gSteps = 8;

    static int bSteps = 8;

    static int totalRange = 0;

    static int rRange = 1;

    static double rStart = 0d;

    static double gStart = Double.POSITIVE_INFINITY;

    static double bStart = Double.NEGATIVE_INFINITY;

    Color getColor(int index) {
        return colors[index];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9548().getColor(index));
    }
}

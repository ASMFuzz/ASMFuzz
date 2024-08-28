import java.awt.*;

public class MyJVMTest_12178 {

    static int index = 9;

    static int minColor = 9;

    static int colorRange = 0;

    static int[] rgbColors = {0,5,8,0,7,0,0,3,0,5};

    static int rSteps = 6;

    static int gSteps = 4;

    static int bSteps = 1016486298;

    static int totalRange = 1;

    static int rRange = 0;

    static double rStart = Double.MAX_VALUE;

    static double gStart = Double.MAX_VALUE;

    static double bStart = Double.MAX_VALUE;

    int getRgbColor(int index) {
        return rgbColors[index];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12178().getRgbColor(index));
    }
}

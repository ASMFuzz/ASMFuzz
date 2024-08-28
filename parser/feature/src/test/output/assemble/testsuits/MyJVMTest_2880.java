import java.awt.*;

public class MyJVMTest_2880 {

    static int index = 1;

    static int minColor = 2;

    static int colorRange = 0;

    static int[] rgbColors = {0,2,0,5,1,-633792606,5,9,3,184267073};

    static int rSteps = 618198537;

    static int gSteps = -1331778955;

    static int bSteps = 2;

    static int totalRange = 8;

    static int rRange = 4;

    static double rStart = Double.NaN;

    static double gStart = Double.NaN;

    static double bStart = Double.MIN_VALUE;

    int getRgbColor(int index) {
        return rgbColors[index];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2880().getRgbColor(index));
    }
}

import java.awt.*;

public class MyJVMTest_5801 {

    static int newSize = 0;

    void fillColorTable() {
        colors = new Color[totalRange];
        rgbColors = new int[totalRange];
        for (int i = 0; i < totalRange; i++) {
            double cosR = Math.cos(i * 2 * Math.PI / rRange + rStart);
            double cosG = Math.cos(i * 2 * Math.PI / gRange + gStart);
            double cosB = Math.cos(i * 2 * Math.PI / bRange + bStart);
            Color color = new Color((int) ((cosR * colorRange) + colorRange) / 2 + minColor, (int) ((cosG * colorRange) + colorRange) / 2 + minColor, (int) ((cosB * colorRange) + colorRange) / 2 + minColor);
            colors[i] = color;
            rgbColors[i] = color.getRGB();
        }
    }

    static int minColor = 0;

    static int colorRange = 3;

    static Color[] colors = {null,null,null,null,null,null,null,null,null,null};

    static int[] rgbColors = {0,7,2,4,1384459230,-1631852049,1,7,1,3};

    static int rSteps = 458566652;

    static int gSteps = -576071734;

    static int bSteps = -192934034;

    static int totalRange = 9;

    static int rRange = 0;

    static int gRange = 263489776;

    static int bRange = 9;

    static double rStart = Double.POSITIVE_INFINITY;

    static double gStart = Double.POSITIVE_INFINITY;

    static double bStart = Double.MAX_VALUE;

    int setSize(int newSize) {
        totalRange = newSize;
        rRange = totalRange / rSteps;
        gRange = totalRange / gSteps;
        bRange = totalRange / bSteps;
        fillColorTable();
        return newSize;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5801().setSize(newSize);
    }
}

import java.awt.*;

public class MyJVMTest_15246 {

    static int newSize = 7;

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

    static int minColor = 5;

    static int colorRange = 7;

    static Color[] colors = {null,null,null,null,null,null,null,null,null,null};

    static int[] rgbColors = {1,2,170788553,2,0,0,-1085603694,3,4,-1910833771};

    static int rSteps = 7;

    static int gSteps = 796173798;

    static int bSteps = -53293194;

    static int totalRange = 1684728466;

    static int rRange = -1950363918;

    static int gRange = 6;

    static int bRange = 0;

    static double rStart = Double.NEGATIVE_INFINITY;

    static double gStart = Double.NEGATIVE_INFINITY;

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
        new MyJVMTest_15246().setSize(newSize);
    }
}

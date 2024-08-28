import java.awt.*;

public class MyJVMTest_17466 {

    static int minColor = 0;

    static int colorRange = 5;

    static Color[] colors = {null,null,null,null,null,null,null,null,null,null};

    static int[] rgbColors = {0,1,6,8,1848870250,8,0,2,-673765082,1682467807};

    static int rSteps = 0;

    static int gSteps = 0;

    static int bSteps = 234963209;

    static int totalRange = 4;

    static int rRange = 7;

    static int gRange = 7;

    static int bRange = 1;

    static double rStart = Double.NEGATIVE_INFINITY;

    static double gStart = Double.MAX_VALUE;

    static double bStart = Double.POSITIVE_INFINITY;

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

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17466().fillColorTable();
    }
}

import java.awt.*;

public class MyJVMTest_7904 {

    static int minColor = -2028651014;

    static int colorRange = 0;

    static Color[] colors = {null,null,null,null,null,null,null,null,null,null};

    static int[] rgbColors = {2,9,0,7,-1266266083,4,0,-737568875,-1767528314,7};

    static int rSteps = 1;

    static int gSteps = 8;

    static int bSteps = 7;

    static int totalRange = 8;

    static int rRange = 8;

    static int gRange = 0;

    static int bRange = 2;

    static double rStart = 0d;

    static double gStart = Double.MAX_VALUE;

    static double bStart = Double.NaN;

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
        new MyJVMTest_7904().fillColorTable();
    }
}

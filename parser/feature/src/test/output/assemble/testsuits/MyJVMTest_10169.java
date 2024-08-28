import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import java.util.Arrays;

public class MyJVMTest_10169 {

    static int total = 0;

    static int num = 3;

    static int[] minsizes = { 1810393659, 2, 0, 0, 0, 0, -1966861257, 2025704707, 7, 0 };

    static int[] prefsizes = { -241107367, 0, 1699578375, 0, 4, 4, 1063950015, -1240047350, 0, 4 };

    static Polygon poly = null;

    static GeneralPath path = null;

    static ImageCanvas unclipped = null;

    static ImageCanvas reference = null;

    static ImageCanvas actual = null;

    static ImageCanvas diff = null;

    static int rows = 0;

    static int cols = 1206640360;

    static int hgap = 1276287488;

    static int vgap = 0;

    int[] calculateSizes(int total, int num, int[] minsizes, int[] prefsizes) {
        if (total <= minsizes[num]) {
            return minsizes;
        }
        if (total >= prefsizes[num]) {
            return prefsizes;
        }
        int[] sizes = new int[total];
        int prevhappy = 0;
        int nhappy = 0;
        int happysize = 0;
        do {
            int addsize = (total - happysize) / (num - nhappy);
            happysize = 0;
            for (int i = 0; i < num; i++) {
                if (sizes[i] >= prefsizes[i] || minsizes[i] + addsize > prefsizes[i]) {
                    happysize += (sizes[i] = prefsizes[i]);
                    nhappy++;
                } else {
                    sizes[i] = minsizes[i] + addsize;
                }
            }
        } while (nhappy < num && nhappy > prevhappy);
        return sizes;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_10169().calculateSizes(total, num, minsizes, prefsizes)));
    }
}

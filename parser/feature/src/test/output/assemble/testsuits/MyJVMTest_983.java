import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import java.util.Arrays;

public class MyJVMTest_983 {

    static int total = 0;

    static int num = 0;

    static int[] minsizes = { 2, 1, 0, 0, 0, 2126704957, 783351820, 9, 425367957, 0 };

    static int[] prefsizes = { 8, -1510515734, 0, 0, -1430973049, 6, -1046742146, 4, 0, 4 };

    static Polygon poly = null;

    static GeneralPath path = null;

    static ImageCanvas unclipped = null;

    static ImageCanvas reference = null;

    static ImageCanvas actual = null;

    static ImageCanvas diff = null;

    static int rows = 9;

    static int cols = -766868304;

    static int hgap = 0;

    static int vgap = 1;

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
        System.out.println(Arrays.asList(new MyJVMTest_983().calculateSizes(total, num, minsizes, prefsizes)));
    }
}

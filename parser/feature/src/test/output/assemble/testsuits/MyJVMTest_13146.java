import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import java.util.Arrays;

public class MyJVMTest_13146 {

    static int total = 3;

    static int num = 0;

    static int[] minsizes = { 1763823685, 4, 1511260762, 0, 2, 2, 7, 0, 571871452, 0 };

    static int[] prefsizes = { 6, -1492453922, 0, 0, 7, 0, 0, 8, 4, -553834321 };

    static int rows = 1449818400;

    static int cols = 0;

    static int hgap = 2;

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
        System.out.println(Arrays.asList(new MyJVMTest_13146().calculateSizes(total, num, minsizes, prefsizes)));
    }
}

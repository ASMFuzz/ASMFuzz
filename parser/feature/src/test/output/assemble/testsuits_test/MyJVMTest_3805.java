import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import java.util.Arrays;

public class MyJVMTest_3805 {

    static int total = 3;

    static int num = -878791561;

    static int[] minsizes = { 0, 0, 6, 1395642688, -1202549996, -1557356256, 4, 1802630594, -251944095, 8 };

    static int[] prefsizes = { 3, 0, 3, 2, 1, 5, 4, 7, -466808593, 5 };

    static int rows = 2;

    static int cols = 0;

    static int hgap = -1663270491;

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
        System.out.println(Arrays.asList(new MyJVMTest_3805().calculateSizes(total, num, minsizes, prefsizes)));
    }
}

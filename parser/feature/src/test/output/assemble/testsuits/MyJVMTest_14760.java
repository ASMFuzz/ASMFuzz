import java.util.*;
import java.awt.geom.*;

public class MyJVMTest_14760 {

    static int want = 0;

    static boolean verbose = false;

    static int GROW_SIZE = 24;

    static float squareflat = Float.POSITIVE_INFINITY;

    static int limit = 3;

    static float[] hold = new float[14];

    static int holdEnd = 0;

    static int holdIndex = 0;

    static int[] levels = {8,0,1,7,-1610806405,6,6,1694697688,0,9};

    static int levelIndex = 1797793055;

    int ensureHoldCapacity(int want) {
        if (holdIndex - want < 0) {
            int have = hold.length - holdIndex;
            int newsize = hold.length + GROW_SIZE;
            float[] newhold = new float[newsize];
            System.arraycopy(hold, holdIndex, newhold, holdIndex + GROW_SIZE, have);
            if (verbose)
                System.err.println("old hold = " + hold + "[" + hold.length + "]");
            if (verbose)
                System.err.println("replacement hold = " + newhold + "[" + newhold.length + "]");
            hold = newhold;
            if (verbose)
                System.err.println("new hold = " + hold + "[" + hold.length + "]");
            if (verbose)
                System.err.println("replacement hold still = " + newhold + "[" + newhold.length + "]");
            holdIndex += GROW_SIZE;
            holdEnd += GROW_SIZE;
        }
        return want;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14760().ensureHoldCapacity(want);
    }
}

import java.util.*;
import java.awt.geom.*;

public class MyJVMTest_5336 {

    static int want = 6;

    static boolean verbose = false;

    static int GROW_SIZE = 24;

    static float squareflat = Float.MAX_VALUE;

    static int limit = 2;

    static float[] hold = new float[14];

    static int holdEnd = 1;

    static int holdIndex = -573772458;

    static int[] levels = {7,4,0,0,0,1,-361037641,1,1,0};

    static int levelIndex = 0;

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
        new MyJVMTest_5336().ensureHoldCapacity(want);
    }
}

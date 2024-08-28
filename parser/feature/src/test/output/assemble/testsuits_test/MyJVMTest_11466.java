import java.util.*;
import java.lang.reflect.*;

public class MyJVMTest_11466 {

    static int x = -2134519028;

    static int crit1 = -1935936648;

    static int crit2 = 132853012;

    static int shortStepsNear = 4;

    static int downShift = 3;

    static int[] testValues = {0,9,-1844807073,3,6,6,8,6,1560259256,0};

    int inc(int x, int crit1, int crit2) {
        int D = shortStepsNear;
        if (crit1 > crit2) {
            int t = crit1;
            crit1 = crit2;
            crit2 = t;
        }
        assert (crit1 <= crit2);
        assert (x <= crit2);
        x += 1;
        if (x > D) {
            if (x < crit1 - D) {
                x += (x << 1) >> downShift;
                if (x > crit1 - D)
                    x = crit1 - D;
            } else if (x >= crit1 + D && x < crit2 - D) {
                x += (x << 1) >> downShift;
                if (x > crit2 - D)
                    x = crit2 - D;
            }
        }
        return x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11466().inc(x, crit1, crit2));
    }
}

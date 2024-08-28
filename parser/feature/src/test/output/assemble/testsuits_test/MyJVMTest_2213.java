import java.util.*;
import java.lang.reflect.*;

public class MyJVMTest_2213 {

    static int x = 6;

    static int crit1 = 5;

    static int crit2 = -481131987;

    static int shortStepsNear = 4;

    static int downShift = 3;

    static int[] testValues = {-1910892079,8,6,0,2,4,2,8,5,0};

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
        System.out.println(new MyJVMTest_2213().inc(x, crit1, crit2));
    }
}

import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_14384 {

    static float actual = 0f;

    static float expected = Float.MAX_VALUE;

    static float tolerance = Float.MAX_VALUE;

    static Window win = null;

    boolean closeMatch(final float actual, final float expected, final float tolerance) {
        return (expected + tolerance) > actual && (expected - tolerance) < actual;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14384().closeMatch(actual, expected, tolerance));
    }
}

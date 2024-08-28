import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_4978 {

    static float actual = Float.POSITIVE_INFINITY;

    static float expected = Float.NEGATIVE_INFINITY;

    static float tolerance = Float.MIN_VALUE;

    static Window win = null;

    boolean closeMatch(final float actual, final float expected, final float tolerance) {
        return (expected + tolerance) > actual && (expected - tolerance) < actual;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4978().closeMatch(actual, expected, tolerance));
    }
}

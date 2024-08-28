import java.math.*;

public class MyJVMTest_15964 {

    static double bdParam1 = Double.MIN_VALUE;

    static BigDecimal bd = new BigDecimal(bdParam1);

    static float f = 0.625908f;

    float checkFloat(BigDecimal bd, float f) {
        float fbd = bd.floatValue();
        if (f != fbd) {
            String message = String.format("Bad conversion:" + "got %g (%a)\texpected %g (%a)", f, f, fbd, fbd);
            throw new RuntimeException(message);
        }
        return fbd;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15964().checkFloat(bd, f);
    }
}

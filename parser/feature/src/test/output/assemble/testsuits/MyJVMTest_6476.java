import java.math.*;

public class MyJVMTest_6476 {

    static char[] bdParam1 = { Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, 'D', Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, 'h', Character.MIN_VALUE, Character.MIN_VALUE };

    static BigDecimal bd = new BigDecimal(bdParam1);

    static float f = Float.MAX_VALUE;

    float checkFloat(BigDecimal bd, float f) {
        float fbd = bd.floatValue();
        if (f != fbd) {
            String message = String.format("Bad conversion:" + "got %g (%a)\texpected %g (%a)", f, f, fbd, fbd);
            throw new RuntimeException(message);
        }
        return fbd;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6476().checkFloat(bd, f);
    }
}

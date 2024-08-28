import java.awt.geom.AffineTransform;

public class MyJVMTest_15036 {

    static AffineTransform at = new AffineTransform();

    static Tester prev = null;

    static Tester next = null;

    AffineTransform concatfix(AffineTransform at) {
        double m00 = at.getScaleX();
        double m10 = at.getShearY();
        double m01 = at.getShearX();
        double m11 = at.getScaleY();
        double m02 = at.getTranslateX();
        double m12 = at.getTranslateY();
        if (Math.abs(m00 - 1.0) < 1E-10)
            m00 = 1.0;
        if (Math.abs(m11 - 1.0) < 1E-10)
            m11 = 1.0;
        if (Math.abs(m02) < 1E-10)
            m02 = 0.0;
        if (Math.abs(m12) < 1E-10)
            m12 = 0.0;
        if (Math.abs(m01) < 1E-15)
            m01 = 0.0;
        if (Math.abs(m10) < 1E-15)
            m10 = 0.0;
        at.setTransform(m00, m10, m01, m11, m02, m12);
        return at;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15036().concatfix(at);
    }
}

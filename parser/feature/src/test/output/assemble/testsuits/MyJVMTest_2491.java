import java.awt.geom.AffineTransform;

public class MyJVMTest_2491 {

    static double[] atParam1 = { 0d, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MAX_VALUE, Double.NaN, 0d, 0.45179216367342645, Double.MIN_VALUE, Double.MAX_VALUE, Double.MIN_VALUE };

    static AffineTransform at = new AffineTransform(atParam1);

    boolean isIdentity(AffineTransform at) {
        return (at.getScaleX() == 1 && at.getScaleY() == 1 && at.getShearX() == 0 && at.getShearY() == 0 && at.getTranslateX() == 0 && at.getTranslateY() == 0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2491().isIdentity(at));
    }
}

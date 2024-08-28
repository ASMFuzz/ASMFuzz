import java.awt.geom.AffineTransform;

public class MyJVMTest_11761 {

    static AffineTransform at = new AffineTransform();

    boolean isIdentity(AffineTransform at) {
        return (at.getScaleX() == 1 && at.getScaleY() == 1 && at.getShearX() == 0 && at.getShearY() == 0 && at.getTranslateX() == 0 && at.getTranslateY() == 0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11761().isIdentity(at));
    }
}

import java.awt.geom.AffineTransform;

public class MyJVMTest_7182 {

    static boolean verbose = false;

    static int numerrors = 6;

    void checkBug4418285() {
        AffineTransform id = new AffineTransform();
        AffineTransform translate0 = AffineTransform.getTranslateInstance(0, 0);
        if (id.isIdentity() != translate0.isIdentity() || id.getType() != translate0.getType()) {
            numerrors++;
            if (verbose) {
                System.err.println("id=        " + id + ", isIdentity()=" + id.isIdentity());
                System.err.println("translate0=" + translate0 + ", isIdentity()=" + translate0.isIdentity());
                System.err.println("equals=" + id.equals(translate0));
                System.err.println();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7182().checkBug4418285();
    }
}

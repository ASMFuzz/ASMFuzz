import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;

public class MyJVMTest_4358 {

    static QuadCurve2D q = null;

    static Point2D p = null;

    static boolean expect = false;

    QuadCurve2D checkPair(QuadCurve2D q, Point2D p, boolean expect) {
        if (q.contains(p.getX(), p.getY()) != expect) {
            String errMsg = "QuadCurve2D " + "p1 = (" + q.getX1() + ", " + q.getY1() + ") " + "p2 = (" + q.getX2() + ", " + q.getY2() + ") " + "control = (" + q.getCtrlX() + ", " + q.getCtrlY() + ") " + "should " + (expect ? "" : "not ") + "contain the point (" + p.getX() + ", " + p.getY() + "), " + "but method returns wrong value!";
            throw new RuntimeException(errMsg);
        }
        return q;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4358().checkPair(q, p, expect);
    }
}

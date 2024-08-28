import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_3370 {

    static Shape s1 = null;

    static Shape s2 = null;

    boolean compareShapes(Shape s1, Shape s2) {
        if (s1 == null || s2 == null)
            return false;
        PathIterator p1 = s1.getPathIterator(null);
        float[] coords1 = { 0f, 0f, 0f, 0f, 0f, 0f };
        PathIterator p2 = s2.getPathIterator(null);
        float[] coords2 = { 0f, 0f, 0f, 0f, 0f, 0f };
        while (!p1.isDone() || !p2.isDone()) {
            if (p1.currentSegment(coords1) != p2.currentSegment(coords2)) {
                System.err.println("Types of segment are different");
                return false;
            }
            for (int i = 0; i < 6; i++) if (coords1[i] != coords2[i]) {
                System.err.println("Coordinate " + i + " are different");
                return false;
            }
            p1.next();
            p2.next();
        }
        if (!(p1.isDone() && p2.isDone())) {
            System.err.println("Length of paths are different");
        }
        return (p1.isDone() && p2.isDone());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3370().compareShapes(s1, s2));
    }
}

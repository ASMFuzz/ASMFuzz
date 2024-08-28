import java.awt.BasicStroke;

public class MyJVMTest_15312 {

    static int N = 10;

    static float DASH_LEN = 3.0f;

    static float DASH_PH = 5000f;

    BasicStroke createStroke() {
        return new BasicStroke(2f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 10.0f, new float[] { DASH_LEN }, DASH_PH) {
        };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15312().createStroke());
    }
}

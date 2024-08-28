import java.awt.*;
import java.awt.image.*;

public class MyJVMTest_4865 {

    static int wrParam1Param1 = 751;

    static int wrParam1Param2 = 825;

    static int wrParam1Param3 = 584;

    static int wrParam1Param4 = 404;

    static int wrParam1Param5 = 157;

    static int[] wrParam1Param6 = { 0, 0, 6, -308547073, -1625184146, 7, 1674496608, 0, 1, 6 };

    static SampleModel wrParam1 = new ComponentSampleModel(wrParam1Param1, wrParam1Param2, wrParam1Param3, wrParam1Param4, wrParam1Param5, wrParam1Param6);

    static int wrParam2Param1 = 643;

    static int wrParam2Param2 = 472;

    static Point wrParam2 = new Point(wrParam2Param1, wrParam2Param2);

    static WritableRaster wr = new WritableRaster(wrParam1, wrParam2);

    WritableRaster fillRaster(WritableRaster wr) {
        int c = 0;
        for (int x = wr.getMinX(); x < wr.getMinX() + wr.getWidth(); x++) {
            for (int y = wr.getMinY(); y < wr.getMinY() + wr.getHeight(); y++) {
                for (int b = 0; b < wr.getNumBands(); b++) {
                    wr.setSample(x, y, b, c++);
                }
            }
        }
        return wr;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4865().fillRaster(wr));
    }
}

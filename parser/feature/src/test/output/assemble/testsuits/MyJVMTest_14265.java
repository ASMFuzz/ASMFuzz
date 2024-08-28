import java.awt.*;
import java.awt.image.*;

public class MyJVMTest_14265 {

    static int wrParam1Param1 = 286;

    static int wrParam1Param2 = 941;

    static int wrParam1Param3 = 55;

    static int wrParam1Param4 = 418;

    static int wrParam1Param5 = 201;

    static int[] wrParam1Param6 = { 1337703786, 1654977216, 0, 0, 0, 1, 5, -223675376, -1316505487, 0 };

    static SampleModel wrParam1 = new ComponentSampleModel(wrParam1Param1, wrParam1Param2, wrParam1Param3, wrParam1Param4, wrParam1Param5, wrParam1Param6);

    static int wrParam2Param1 = 838;

    static DataBuffer wrParam2 = new DataBufferByte(wrParam2Param1);

    static Rectangle wrParam3 = new Rectangle();

    static Point wrParam4Param1 = new Point();

    static Point wrParam4 = new Point(wrParam4Param1);

    static int wrParam5Param1Param1 = 848;

    static int wrParam5Param1Param2 = 101;

    static int wrParam5Param1Param3 = 226;

    static int wrParam5Param1Param4 = 332;

    static int wrParam5Param1Param5 = 303;

    static int[] wrParam5Param1Param6 = { 0, 0, 0, 7, 3, 2, -1421889158, 9, 0, 0 };

    static int[] wrParam5Param1Param7 = { 2026245212, -2137570326, -747200285, 8, -401111893, 0, 0, 0, 0, -963523528 };

    static SampleModel wrParam5Param1 = new ComponentSampleModel(wrParam5Param1Param1, wrParam5Param1Param2, wrParam5Param1Param3, wrParam5Param1Param4, wrParam5Param1Param5, wrParam5Param1Param6, wrParam5Param1Param7);

    static byte[] wrParam5Param2Param1 = { -67, 59, -100, -12, -114, -89, -58, -116, -5, -123 };

    static int wrParam5Param2Param2 = 493;

    static int wrParam5Param2Param3 = 633;

    static DataBuffer wrParam5Param2 = new DataBufferByte(wrParam5Param2Param1, wrParam5Param2Param2, wrParam5Param2Param3);

    static Point wrParam5Param3 = new Point();

    static WritableRaster wrParam5 = new WritableRaster(wrParam5Param1, wrParam5Param2, wrParam5Param3);

    static WritableRaster wr = new WritableRaster(wrParam1, wrParam2, wrParam3, wrParam4, wrParam5);

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
        System.out.println(new MyJVMTest_14265().fillRaster(wr));
    }
}

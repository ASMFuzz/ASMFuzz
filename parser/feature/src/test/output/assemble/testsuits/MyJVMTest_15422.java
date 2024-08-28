import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.imageio.event.*;
import javax.imageio.stream.*;

public class MyJVMTest_15422 {

    static ImageReader source = null;

    static int theImageParam1 = 589;

    static int theImageParam2 = 412;

    static int theImageParam3 = 994;

    static int theImageParam4Param1 = 718;

    static int theImageParam4Param2 = 552;

    static byte[] theImageParam4Param3 = { 40, 30, -53, -102, -38, 99, -52, -75, -66, 11 };

    static byte[] theImageParam4Param4 = { -62, 60, 27, -66, 93, -60, -109, -21, 65, 124 };

    static byte[] theImageParam4Param5 = { 19, -127, 121, -79, -81, -122, -80, 90, -20, -116 };

    static byte[] theImageParam4Param6 = { 33, -9, -111, -2, 85, 66, 46, 65, -55, 73 };

    static IndexColorModel theImageParam4 = new IndexColorModel(theImageParam4Param1, theImageParam4Param2, theImageParam4Param3, theImageParam4Param4, theImageParam4Param5, theImageParam4Param6);

    static BufferedImage theImage = new BufferedImage(theImageParam1, theImageParam2, theImageParam3, theImageParam4);

    static int pass = 8;

    static int minPass = 0;

    static int maxPass = 0;

    static int minX = 0;

    static int minY = 0;

    static int periodX = 0;

    static int periodY = 8;

    static int[] bands = { 169219859, 1, -241037987, 1842183411, 4, 0, 4, 0, -696921279, 0 };

    static boolean isPassStarted = false;

    static int numPasses = 0;

    int[] passStarted(ImageReader source, BufferedImage theImage, int pass, int minPass, int maxPass, int minX, int minY, int periodX, int periodY, int[] bands) {
        if (isPassStarted) {
            throw new RuntimeException("reentered passStarted!");
        }
        isPassStarted = true;
        numPasses++;
        return bands;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15422().passStarted(source, theImage, pass, minPass, maxPass, minX, minY, periodX, periodY, bands);
    }
}

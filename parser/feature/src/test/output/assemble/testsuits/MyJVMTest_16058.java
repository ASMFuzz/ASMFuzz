import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.imageio.event.*;
import javax.imageio.stream.*;

public class MyJVMTest_16058 {

    static ImageReader source = null;

    static int theImageParam1 = 422;

    static int theImageParam2 = 377;

    static int theImageParam3 = 128;

    static int theImageParam4Param1 = 639;

    static int theImageParam4Param2 = 893;

    static byte[] theImageParam4Param3 = { 5, 55, 61, -90, 125, -106, -89, 29, -97, 1 };

    static int theImageParam4Param4 = 974;

    static boolean theImageParam4Param5 = true;

    static IndexColorModel theImageParam4 = new IndexColorModel(theImageParam4Param1, theImageParam4Param2, theImageParam4Param3, theImageParam4Param4, theImageParam4Param5);

    static BufferedImage theImage = new BufferedImage(theImageParam1, theImageParam2, theImageParam3, theImageParam4);

    static boolean isPassStarted = false;

    BufferedImage passComplete(ImageReader source, BufferedImage theImage) {
        if (!isPassStarted) {
            throw new RuntimeException("passComplete without passStarted!");
        }
        isPassStarted = false;
        return theImage;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16058().passComplete(source, theImage);
    }
}

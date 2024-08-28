import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.imageio.event.*;
import javax.imageio.stream.*;

public class MyJVMTest_6563 {

    static ImageReader source = null;

    static int theImageParam1 = 4;

    static int theImageParam2 = 403;

    static int theImageParam3 = 1;

    static int theImageParam4Param1 = 908;

    static int theImageParam4Param2 = 221;

    static byte[] theImageParam4Param3 = { -115, 25, 69, 49, -102, 65, 26, -55, 90, 39 };

    static int theImageParam4Param4 = 412;

    static boolean theImageParam4Param5 = false;

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
        new MyJVMTest_6563().passComplete(source, theImage);
    }
}

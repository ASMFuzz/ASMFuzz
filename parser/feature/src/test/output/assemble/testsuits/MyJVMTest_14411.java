import java.io.*;
import java.net.URI;

public class MyJVMTest_14411 {

    static String inClassFileParam1Param1 = "L));kvrOb:";

    static String inClassFileParam1Param2 = ">:q+j!4d|f";

    static String inClassFileParam1Param3 = "0`K8O[vb}~";

    static String inClassFileParam1Param4 = "6IJfjChU>\"";

    static String inClassFileParam1Param5 = "uJt6>:2F5l";

    static URI inClassFileParam1 = new URI(inClassFileParam1Param1, inClassFileParam1Param2, inClassFileParam1Param3, inClassFileParam1Param4, inClassFileParam1Param5);

    static File inClassFile = new File(inClassFileParam1);

    static String attrFileParam1 = "BZ[b%-S#$[";

    static String attrFileParam2 = "uX)BzC.VQ:";

    static File attrFile = new File(attrFileParam1, attrFileParam2);

    static String outClassFileParam1Param1Param1 = "*%E;ZxlTQN";

    static String outClassFileParam1Param1Param2 = "L//_*tp}\\&";

    static String outClassFileParam1Param1Param3 = "@E99wccK_t";

    static String outClassFileParam1Param1Param4 = "<go$v&+fTE";

    static String outClassFileParam1Param1Param5 = "^H/S?[BL(b";

    static URI outClassFileParam1Param1 = new URI(outClassFileParam1Param1Param1, outClassFileParam1Param1Param2, outClassFileParam1Param1Param3, outClassFileParam1Param1Param4, outClassFileParam1Param1Param5);

    static File outClassFileParam1 = new File(outClassFileParam1Param1);

    static String outClassFileParam2 = "#_{NQ$5V9S";

    static File outClassFile = new File(outClassFileParam1, outClassFileParam2);

    static byte[] orig = {114,-69,-126,49,70,8,-5,49,-43,-98};

    static byte[] sdeAttr = {-118,-13,3,21,-52,63,49,-70,110,-29};

    static byte[] gen = {-39,-118,93,-90,54,22,105,49,76,-34};

    static int genPos = 0;

    File install(File inClassFile, File attrFile, File outClassFile) throws IOException {
        new InstallSDE(inClassFile, attrFile, outClassFile);
        return outClassFile;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14411().install(inClassFile, attrFile, outClassFile);
    }
}

import java.io.*;
import java.net.URI;

public class MyJVMTest_16833 {

    static String inOutClassFileParam1Param1 = "Z_f@*7=AfN";

    static URI inOutClassFileParam1 = new URI(inOutClassFileParam1Param1);

    static File inOutClassFile = new File(inOutClassFileParam1);

    static String attrFileParam1Param1Param1 = "|hK'd?(Xa.";

    static String attrFileParam1Param1Param2 = "m eFwO8>_H";

    static String attrFileParam1Param1Param3 = "@5{'166zqD";

    static int attrFileParam1Param1Param4 = 455;

    static String attrFileParam1Param1Param5 = " JQ\"@*Fuw#";

    static String attrFileParam1Param1Param6 = "|v+[C~Kw;C";

    static String attrFileParam1Param1Param7 = "U~Q5$:ntwT";

    static URI attrFileParam1Param1 = new URI(attrFileParam1Param1Param1, attrFileParam1Param1Param2, attrFileParam1Param1Param3, attrFileParam1Param1Param4, attrFileParam1Param1Param5, attrFileParam1Param1Param6, attrFileParam1Param1Param7);

    static File attrFileParam1 = new File(attrFileParam1Param1);

    static String attrFileParam2 = "b81khyg r}";

    static File attrFile = new File(attrFileParam1, attrFileParam2);

    static byte[] orig = {-19,111,85,-78,-46,-88,-128,103,4,-108};

    static byte[] sdeAttr = {117,-125,-10,12,41,-51,-117,31,-16,50};

    static byte[] gen = {11,-73,74,-120,67,26,-99,-65,73,109};

    static int genPos = 0;

    File install(File inOutClassFile, File attrFile) throws IOException {
        File tmpFile = new File(inOutClassFile.getPath() + "tmp");
        new InstallSDE(inOutClassFile, attrFile, tmpFile);
        if (!inOutClassFile.delete()) {
            throw new IOException("inOutClassFile.delete() failed");
        }
        if (!tmpFile.renameTo(inOutClassFile)) {
            throw new IOException("tmpFile.renameTo(inOutClassFile) failed");
        }
        return inOutClassFile;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16833().install(inOutClassFile, attrFile);
    }
}

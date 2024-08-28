import java.io.*;
import java.net.URI;

public class MyJVMTest_13778 {

    static String inOutClassFileParam1 = "\\sQqM=1mNd";

    static File inOutClassFile = new File(inOutClassFileParam1);

    static String attrFileParam1Param1 = "a\\zUn$In=*";

    static String attrFileParam1Param2 = "<P'(sKX+$A";

    static String attrFileParam1Param3 = "fPH5]y*4E{";

    static String attrFileParam1Param4 = "5(Vp1+\"gM@";

    static URI attrFileParam1 = new URI(attrFileParam1Param1, attrFileParam1Param2, attrFileParam1Param3, attrFileParam1Param4);

    static File attrFile = new File(attrFileParam1);

    static byte[] orig = {-71,-11,-89,24,123,31,-37,40,124,-95};

    static byte[] sdeAttr = {116,-68,69,-59,55,98,-120,109,-10,-30};

    static byte[] gen = {-72,-120,-42,-119,-49,61,-33,-116,22,-20};

    static int genPos = 0;

    File install(File inOutClassFile, File attrFile) throws IOException {
        File tmpFile = new File(inOutClassFile.getPath() + "tmp-out");
        File tmpInOutClassFile = new File(inOutClassFile.getPath() + "tmp-in");
        if (!inOutClassFile.renameTo(tmpInOutClassFile)) {
            throw new IOException("tmp copy of inOutClassFile failed");
        }
        new InstallSDE(tmpInOutClassFile, attrFile, tmpFile);
        if (!tmpInOutClassFile.delete()) {
            throw new IOException("tmpInOutClassFile.delete() failed");
        }
        if (!tmpFile.renameTo(inOutClassFile)) {
            throw new IOException("tmpFile.renameTo(inOutClassFile) failed");
        }
        return inOutClassFile;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13778().install(inOutClassFile, attrFile);
    }
}

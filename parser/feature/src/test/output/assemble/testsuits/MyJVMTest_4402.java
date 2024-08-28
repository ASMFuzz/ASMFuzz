import java.io.*;
import java.net.URI;

public class MyJVMTest_4402 {

    static String inOutClassFileParam1 = "jL7ZpC C=C";

    static File inOutClassFile = new File(inOutClassFileParam1);

    static String attrFileParam1Param1 = "*o,njoR3M#";

    static String attrFileParam1Param2 = "E'1d$B\\Z[/";

    static String attrFileParam1Param3 = ".B]+GIyIY?";

    static String attrFileParam1Param4 = "Vxqi^u+#+{";

    static String attrFileParam1Param5 = "+c??Xr7T=.";

    static URI attrFileParam1 = new URI(attrFileParam1Param1, attrFileParam1Param2, attrFileParam1Param3, attrFileParam1Param4, attrFileParam1Param5);

    static File attrFile = new File(attrFileParam1);

    static byte[] orig = {-91,-89,116,58,73,-10,39,17,-81,-100};

    static byte[] sdeAttr = {-109,37,56,-21,-20,-99,-116,71,102,-47};

    static byte[] gen = {-6,31,-121,50,-36,-104,-71,12,-125,-16};

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
        new MyJVMTest_4402().install(inOutClassFile, attrFile);
    }
}

import java.io.*;

public class MyJVMTest_7307 {

    static String inOutClassFileParam1 = "lHER5D&yuP";

    static File inOutClassFile = new File(inOutClassFileParam1);

    static String attrFileParam1 = "Km|;8^7_;z";

    static String attrFileParam2 = "HkiNb;@3Z6";

    static File attrFile = new File(attrFileParam1, attrFileParam2);

    static byte[] orig = {70,-30,-16,-14,73,-77,-51,-119,66,64};

    static byte[] sdeAttr = {45,41,50,-104,40,42,68,81,14,27};

    static byte[] gen = {75,21,104,-111,-36,-2,-120,-46,34,104};

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
        new MyJVMTest_7307().install(inOutClassFile, attrFile);
    }
}

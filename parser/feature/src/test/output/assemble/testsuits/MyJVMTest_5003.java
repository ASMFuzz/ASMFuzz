import java.io.*;

public class MyJVMTest_5003 {

    static String inClassFileParam1 = "*Ygzx9p2uy";

    static String inClassFileParam2 = "jdr*@Emv K";

    static File inClassFile = new File(inClassFileParam1, inClassFileParam2);

    static String attrFileParam1 = "ds,j:-t}Ia";

    static File attrFile = new File(attrFileParam1);

    static String outClassFileParam1 = ")-o|%ow]%u";

    static File outClassFile = new File(outClassFileParam1);

    static byte[] orig = {108,-28,47,-107,32,16,125,60,-33,-118};

    static byte[] sdeAttr = {-96,-114,13,-38,2,-39,27,62,-83,53};

    static byte[] gen = {-46,96,-78,-101,105,74,-60,56,-92,61};

    static int genPos = 0;

    File install(File inClassFile, File attrFile, File outClassFile) throws IOException {
        new InstallSDE(inClassFile, attrFile, outClassFile);
        return outClassFile;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5003().install(inClassFile, attrFile, outClassFile);
    }
}

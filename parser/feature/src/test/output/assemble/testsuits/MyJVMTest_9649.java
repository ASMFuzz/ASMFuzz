import java.io.*;
import java.nio.channels.*;
import java.net.URI;

public class MyJVMTest_9649 {

    static String fParam1Param1 = "=ACF5u2A!^";

    static String fParam1Param2 = "`V_u{E@8/A";

    static String fParam1Param3 = "%gsP=g~xI~";

    static int fParam1Param4 = 536;

    static String fParam1Param5 = "_?]QU'ij|&";

    static String fParam1Param6 = "ka1f W6#$e";

    static String fParam1Param7 = ">9Jq&Nx.s+";

    static URI fParam1 = new URI(fParam1Param1, fParam1Param2, fParam1Param3, fParam1Param4, fParam1Param5, fParam1Param6, fParam1Param7);

    static File f = new File(fParam1);

    static long size = 0;

    File initTestFile(File f, long size) throws Exception {
        try (BufferedWriter awriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "8859_1"))) {
            for (int i = 0; i < size; i++) {
                awriter.write("e");
            }
        }
        return f;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9649().initTestFile(f, size);
    }
}

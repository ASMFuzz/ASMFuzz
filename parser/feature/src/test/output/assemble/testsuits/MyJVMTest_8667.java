import java.io.*;
import java.nio.channels.*;
import java.net.URI;

public class MyJVMTest_8667 {

    static String fParam1Param1 = "c55$VwA~ex";

    static String fParam1Param2 = "[&kE{{A3A=";

    static String fParam1Param3 = "uUi_`ffS7j";

    static URI fParam1 = new URI(fParam1Param1, fParam1Param2, fParam1Param3);

    static File f = new File(fParam1);

    static long size = 9223372036854775807L;

    File initTestFile(File f, long size) throws Exception {
        try (BufferedWriter awriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "8859_1"))) {
            for (int i = 0; i < size; i++) {
                awriter.write("e");
            }
        }
        return f;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8667().initTestFile(f, size);
    }
}

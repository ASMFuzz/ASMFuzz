import java.io.*;
import java.nio.channels.*;

public class MyJVMTest_489 {

    static String fParam1 = "Gp;FhtVB;Y";

    static String fParam2 = "1\"-O?ak)pT";

    static File f = new File(fParam1, fParam2);

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
        new MyJVMTest_489().initTestFile(f, size);
    }
}

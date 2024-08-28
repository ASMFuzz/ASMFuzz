import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class MyJVMTest_1645 {

    static String fnames = "W`}?@Q,v#]";

    String cleanup(String... fnames) throws Throwable {
        for (String fname : fnames) {
            Files.deleteIfExists(Paths.get(fname));
        }
        return fnames;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1645().cleanup(fnames);
    }
}

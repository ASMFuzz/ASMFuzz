import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class MyJVMTest_10867 {

    static String fnames = "w=XoHG\\h<v";

    String cleanup(String... fnames) throws Throwable {
        for (String fname : fnames) {
            Files.deleteIfExists(Paths.get(fname));
        }
        return fnames;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10867().cleanup(fnames);
    }
}

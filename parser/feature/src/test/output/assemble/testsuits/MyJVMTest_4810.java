import java.io.*;
import java.util.*;
import java.util.zip.*;
import javax.tools.*;

public class MyJVMTest_4810 {

    static File file = null;

    boolean isFileLookupCaseSignificant() throws IOException {
        File lower = new File("test.txt");
        File upper = new File(lower.getPath().toUpperCase());
        if (upper.exists()) {
            upper.delete();
        }
        try (FileWriter out = new FileWriter(lower)) {
        }
        return !upper.exists();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4810().isFileLookupCaseSignificant());
    }
}

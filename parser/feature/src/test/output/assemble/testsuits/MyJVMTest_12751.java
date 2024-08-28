import java.io.*;
import java.util.*;

public class MyJVMTest_12751 {

    static String patternFileName = "v|,\\:#,/Hb";

    static String outDir = "F<cLwK{xj>";

    static List<String> lines = new ArrayList<>();

    void load() throws IOException {
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new FileReader(patternFileName));
            String s = rd.readLine();
            while (s != null) {
                lines.add(s);
                s = rd.readLine();
            }
        } finally {
            if (rd != null) {
                rd.close();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12751().load();
    }
}

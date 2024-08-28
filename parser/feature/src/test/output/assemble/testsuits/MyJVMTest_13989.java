import java.io.*;
import java.util.*;

public class MyJVMTest_13989 {

    static int n = 0;

    static String patternFileName = "l'7ilgiJOa";

    static String outDir = "/L;'rqTUEv";

    static List<String> lines = new ArrayList<>();

    static String prefix = "LoadableClass";

    String generate(int n) throws IOException {
        PrintStream out = null;
        String tokens = Integer.toString(n);
        if (tokens.length() == 1)
            tokens = "00" + tokens;
        else if (tokens.length() == 2)
            tokens = "0" + tokens;
        try {
            out = new PrintStream(new FileOutputStream(new File(outDir, prefix + tokens + ".java")));
            for (int i = 0; i < lines.size(); ++i) {
                String line = lines.get(i);
                out.println(line.replaceAll("XYZ", tokens));
            }
        } finally {
            if (out != null) {
                out.close();
            }
        }
        return tokens;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13989().generate(n);
    }
}

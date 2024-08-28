import java.io.*;
import java.util.*;

public class MyJVMTest_8900 {

    static int n = 1296290513;

    static String patternFileName = "x6tRH7$#=K";

    static String outDir = "D<*_?d~V[&";

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
        new MyJVMTest_8900().generate(n);
    }
}

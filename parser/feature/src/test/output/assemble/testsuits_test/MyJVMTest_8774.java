import java.io.*;
import java.util.*;

public class MyJVMTest_8774 {

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

    void generate(int n) throws IOException {
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
    }

    static String patternFileName = "(?tJ&gQ 4R";

    static String outDir = "(n~ta,a#\\5";

    static List<String> lines = new ArrayList<>();

    static String prefix = "LoadableClass";

    void run() throws IOException {
        load();
        for (int i = 1; i < 101; ++i) generate(i);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8774().run();
    }
}

import java.io.*;

public class MyJVMTest_235 {

    static String s = "]#TV~5_W{{";

    String filter(String s) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader in = new BufferedReader(new StringReader(s));
        try {
            String line;
            while ((line = in.readLine()) != null) {
                if (line.indexOf("public static final") > 0) {
                    sb.append(line.trim());
                    sb.append('\n');
                }
            }
        } finally {
            in.close();
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_235().filter(s));
    }
}

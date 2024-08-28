import java.io.*;

public class MyJVMTest_9386 {

    static String s = "xq)7;L1H`f";

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
        System.out.println(new MyJVMTest_9386().filter(s));
    }
}

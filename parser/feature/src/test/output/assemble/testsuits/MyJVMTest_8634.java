import java.io.*;

public class MyJVMTest_8634 {

    static String s = "[\\};kh0:Nb";

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
        System.out.println(new MyJVMTest_8634().filter(s));
    }
}

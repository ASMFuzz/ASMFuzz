import java.io.*;

public class MyJVMTest_1582 {

    static String s = "9Q3ka/8; I";

    static int good = 7;

    int test(String s, int good) throws Exception {
        int c, line;
        LineNumberReader r = new LineNumberReader(new StringReader(s), 2);
        if ((c = r.read()) >= 0) {
            while (r.readLine() != null) ;
        }
        line = r.getLineNumber();
        if (line != good) {
            throw new Exception("Failed test: Expected line number " + good + " Got: " + line);
        }
        return line;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1582().test(s, good);
    }
}

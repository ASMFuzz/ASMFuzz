import java.io.*;

public class MyJVMTest_7384 {

    static String filename = "E.2olp\"YsR";

    static String body = "r-N'%Kx++$";

    static File testdir = new File("8013357");

    static boolean isList = false;

    static String name = "0b(gJUf+u}";

    File writeFile(final String filename, final String body) throws IOException {
        final File f = new File(testdir, filename);
        f.getParentFile().mkdirs();
        final FileWriter out = new FileWriter(f);
        out.write(body);
        out.close();
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7384().writeFile(filename, body));
    }
}

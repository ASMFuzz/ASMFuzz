import java.io.*;

public class MyJVMTest_16915 {

    static String filename = "E.[Vlo.1>&";

    static String body = "1.el)E|4n?";

    static File testdir = new File("8013357");

    static boolean isList = false;

    static String name = "bq'bbLdHD&";

    File writeFile(final String filename, final String body) throws IOException {
        final File f = new File(testdir, filename);
        f.getParentFile().mkdirs();
        final FileWriter out = new FileWriter(f);
        out.write(body);
        out.close();
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16915().writeFile(filename, body));
    }
}

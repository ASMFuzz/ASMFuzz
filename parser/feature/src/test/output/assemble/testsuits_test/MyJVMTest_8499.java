import java.io.File;

public class MyJVMTest_8499 {

    static String prefix = "Qihh2]@`*c";

    static String suffix = "Qx*>VH*7x6";

    static File dir = new File(".");

    String cky(String prefix, String suffix) throws Exception {
        File f = File.createTempFile(prefix, suffix, dir);
        f.deleteOnExit();
        System.err.println("\"" + prefix + "\", \"" + suffix + "\" --> " + f.getPath());
        return suffix;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8499().cky(prefix, suffix);
    }
}

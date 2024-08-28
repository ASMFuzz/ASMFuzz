import java.io.File;

public class MyJVMTest_18089 {

    static String prefix = " W3yz8Z9s;";

    static String suffix = ">e.@ehS,\\_";

    static File dir = new File(".");

    String cky(String prefix, String suffix) throws Exception {
        File f = File.createTempFile(prefix, suffix, dir);
        f.deleteOnExit();
        System.err.println("\"" + prefix + "\", \"" + suffix + "\" --> " + f.getPath());
        return suffix;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18089().cky(prefix, suffix);
    }
}

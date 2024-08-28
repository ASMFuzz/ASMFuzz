import java.io.*;

public class MyJVMTest_10790 {

    static String label = "I'60flPf;R";

    static String path = "U8_NWLvixi";

    String printCanonPath(String label, String path) throws Exception {
        File f = new File(path);
        System.out.println(label + " path = " + f.getCanonicalPath());
        return label;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10790().printCanonPath(label, path);
    }
}

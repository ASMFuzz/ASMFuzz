import java.io.*;

public class MyJVMTest_1570 {

    static String label = "HJ>Vt;c=Iq";

    static String path = "<tG]|Ry!:1";

    String printCanonPath(String label, String path) throws Exception {
        File f = new File(path);
        System.out.println(label + " path = " + f.getCanonicalPath());
        return label;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1570().printCanonPath(label, path);
    }
}

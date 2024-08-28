import java.io.*;

public class MyJVMTest_3742 {

    static String path = "!d\"<?.e+fD";

    static String ans = "Q]A~uZ6-1_";

    static boolean ignoreCase = false;

    String ck(String path, String ans) throws Exception {
        File f = new File(path);
        String p = f.getAbsolutePath();
        if ((ignoreCase && p.equalsIgnoreCase(ans)) || p.equals(ans))
            System.err.println(path + " ==> " + p);
        else
            throw new Exception(path + ": expected " + ans + ", got " + p);
        return p;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3742().ck(path, ans);
    }
}

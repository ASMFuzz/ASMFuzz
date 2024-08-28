import java.io.*;

public class MyJVMTest_4017 {

    static String path = "[RS$`Z)KPN";

    static boolean ans = false;

    boolean ck(String path, boolean ans) throws Exception {
        File f = new File(path);
        boolean x = f.isAbsolute();
        if (x != ans)
            throw new Exception(path + ": expected " + ans + ", got " + x);
        System.err.println(path + " ==> " + x);
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4017().ck(path, ans);
    }
}

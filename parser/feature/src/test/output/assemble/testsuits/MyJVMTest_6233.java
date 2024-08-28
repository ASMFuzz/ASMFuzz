import java.io.*;

public class MyJVMTest_6233 {

    static String path = "=h&TBiv9#*";

    static boolean ans = false;

    boolean ck(String path, boolean ans) throws Exception {
        File f = new File(path);
        boolean x = f.isHidden();
        if (x != ans)
            throw new Exception(path + ": expected " + ans + ", got " + x);
        System.err.println(path + " ==> " + x);
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6233().ck(path, ans);
    }
}

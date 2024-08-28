import java.io.*;

public class MyJVMTest_13370 {

    static String path = "h8 Pc8gW*-";

    static boolean ans = true;

    boolean ck(String path, boolean ans) throws Exception {
        File f = new File(path);
        boolean x = f.isAbsolute();
        if (x != ans)
            throw new Exception(path + ": expected " + ans + ", got " + x);
        System.err.println(path + " ==> " + x);
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13370().ck(path, ans);
    }
}

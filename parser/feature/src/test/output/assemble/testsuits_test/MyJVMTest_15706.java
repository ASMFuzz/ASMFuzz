import java.io.*;

public class MyJVMTest_15706 {

    static String path = "HcWJ+tO9aX";

    static boolean ans = true;

    boolean ck(String path, boolean ans) throws Exception {
        File f = new File(path);
        boolean x = f.isHidden();
        if (x != ans)
            throw new Exception(path + ": expected " + ans + ", got " + x);
        System.err.println(path + " ==> " + x);
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15706().ck(path, ans);
    }
}

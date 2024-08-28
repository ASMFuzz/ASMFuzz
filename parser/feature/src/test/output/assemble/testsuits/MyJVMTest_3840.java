import java.io.*;

public class MyJVMTest_3840 {

    static String cmd = "wXQ%xtH`sA";

    static String[] cmdarray = { "])ewF]({rY", "UPze#>kjj5", "?0=w38tj[3", "HyApT?!,cD", "wCF\"PGKk,?", "xD/}$?~uF ", "sCDW,#<<\\a", "ps$D>_M\"|h", "Zs@H4W,4`-", ".wy=(PQ|gu" };

    static boolean flag = true;

    File testExec(String cmd, String[] cmdarray, boolean flag) throws Exception {
        File dir = new File(".");
        File[] files = dir.listFiles();
        String curDir = dir.getCanonicalPath();
        for (int i = 0; i < files.length; i++) {
            File f = files[i];
            if (f.isDirectory() && (new File(f, "SetCwd.class")).exists()) {
                String newDir = f.getCanonicalPath();
                Process p = null;
                if (flag) {
                    p = Runtime.getRuntime().exec(cmd, null, f);
                } else {
                    p = Runtime.getRuntime().exec(cmdarray, null, f);
                }
                BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String s = in.readLine();
                if (!s.startsWith(newDir)) {
                    throw new Exception("inconsistent directory after exec");
                }
                p.waitFor();
            }
        }
        System.out.println(curDir);
        return dir;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3840().testExec(cmd, cmdarray, flag);
    }
}

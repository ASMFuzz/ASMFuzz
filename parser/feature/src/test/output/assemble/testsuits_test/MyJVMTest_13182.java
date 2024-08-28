import java.io.*;

public class MyJVMTest_13182 {

    static String cmd = "i2%nqZvt;.";

    static String[] cmdarray = { "713;=t!UhT", "'o@T}L)+N~", "h6N*na_/R=", "-.aqN?'E?\\", " P!?T-Fy@}", "dEfde=\"%_/", "DzKR-)y_<}", "$-,&^n!O>E", "}K(K%uGaOh", ": \\MB_Cwp2" };

    static boolean flag = false;

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
        new MyJVMTest_13182().testExec(cmd, cmdarray, flag);
    }
}

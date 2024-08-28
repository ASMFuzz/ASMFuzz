import java.awt.Font;
import java.io.File;

public class MyJVMTest_14261 {

    static String text = "*^s!n^_PZ'";

    static String script = "(Fe!!'^Nb$";

    static String filename = "R3<c ,}<52";

    static boolean failed = false;

    static Font dialog = new Font(Font.DIALOG, Font.PLAIN, 12);

    static String windowsFontDir = "c:\\windows\\fonts";

    String test(String text, String script, String filename) {
        File f = new File(windowsFontDir, filename);
        if (!f.exists()) {
            System.out.println("Can't find required font file: " + filename);
            return;
        }
        System.out.println("found:" + f + " for " + script);
        if (dialog.canDisplayUpTo(text) != -1) {
            failed = true;
            System.out.println("No codepoint for " + script);
        }
        return script;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14261().test(text, script, filename);
    }
}

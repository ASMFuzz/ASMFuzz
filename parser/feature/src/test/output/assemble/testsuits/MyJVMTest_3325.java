import javax.swing.*;
import java.awt.*;

public class MyJVMTest_3325 {

    static String dialogParam1Param1 = "Uczji2Sq?n";

    static Frame dialogParam1 = new Frame(dialogParam1Param1);

    static boolean dialogParam2 = true;

    static Dialog dialog = new Dialog(dialogParam1, dialogParam2);

    static String ctr = "FKH+ST3U*`";

    String assertEmptyTitle(Dialog dialog, String ctr) {
        String title = dialog.getTitle();
        if (title == null || title.length() > 0) {
            throw new RuntimeException("Title is not empty for constructor " + ctr);
        }
        return title;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3325().assertEmptyTitle(dialog, ctr);
    }
}

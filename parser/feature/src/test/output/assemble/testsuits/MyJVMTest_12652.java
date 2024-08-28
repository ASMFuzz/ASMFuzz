import javax.swing.*;
import java.awt.*;

public class MyJVMTest_12652 {

    static Frame dialogParam1Param1 = new Frame();

    static Window dialogParam1 = new Window(dialogParam1Param1);

    static String dialogParam2 = "`n_~Xp9/Vw";

    static Dialog dialog = new Dialog(dialogParam1, dialogParam2);

    static String ctr = "Y`wuY~,>Ui";

    String assertEmptyTitle(Dialog dialog, String ctr) {
        String title = dialog.getTitle();
        if (title == null || title.length() > 0) {
            throw new RuntimeException("Title is not empty for constructor " + ctr);
        }
        return title;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12652().assertEmptyTitle(dialog, ctr);
    }
}

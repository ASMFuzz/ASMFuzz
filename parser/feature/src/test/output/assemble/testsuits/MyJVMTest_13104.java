import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class MyJVMTest_13104 {

    static Graphics g = new Graphics2D();

    Graphics paint(Graphics g) {
        g.setFont(new Font("Helvetica", Font.BOLD, 12));
        g.drawString("PRINTING TEST", 1, 10);
        g.drawString(" 4846344: Confirm that cancelling the native dialog will not prompt for file.", 1, 25);
        g.drawString(" 4851365: Confirm that printing in native dialog shows test_file_name.prn as default.", 1, 40);
        g.drawString(" 4851321: Confirm that in the Common Range dialog, page ranges is set to 1-6.", 1, 55);
        g.drawString(" 4851316: Confirm that NPE is not thrown upon selecting Common Selection dialog.", 1, 70);
        g.drawString(" 4863656: Confirm that no IAE is thrown when printing in native dialog.", 1, 85);
        g.drawString(" 4864444: Confirm that the default directory in Native 2 is same as current one with no filename set.", 1, 100);
        g.drawString(" 5046198: Confirm that the default filename in Common Range dialog when printing to a file is same as that of PrintToFile dialog.", 1, 115);
        g.drawString(" 6293139: In Common Range dialog, change printer before printing then confirm the chosen printer.", 1, 130);
        return g;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13104().paint(g);
    }
}

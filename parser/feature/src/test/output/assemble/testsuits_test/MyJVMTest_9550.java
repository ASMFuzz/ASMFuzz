import javax.swing.*;
import java.awt.*;

public class MyJVMTest_9550 {

    static String LONG_TEXT = "Copyright 2010 Sun Microsystems, Inc.  All Rights Reserved. " + "DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER. " + "This code is free software; you can redistribute it and/or modify it " + "under the terms of the GNU General Public License version 2 only, as " + "published by the Free Software Foundation. ";

    void run() {
        JTextArea textArea = new JTextArea(LONG_TEXT);
        Dimension preferredSize = textArea.getPreferredSize();
        if (preferredSize.width <= 0 || preferredSize.height <= 0) {
            throw new RuntimeException("Invalid preferred size " + preferredSize);
        }
        JTextArea textAreaLW = new JTextArea(LONG_TEXT);
        textAreaLW.setLineWrap(true);
        Dimension preferredSizeLW = textAreaLW.getPreferredSize();
        if (preferredSizeLW.width <= 0 || preferredSizeLW.height <= 0) {
            throw new RuntimeException("Invalid preferred size " + preferredSizeLW);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9550().run();
    }
}

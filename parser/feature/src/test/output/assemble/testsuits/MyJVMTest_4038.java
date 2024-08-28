import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_4038 {

    static TestDialog dialog = null;

    String getFailureMessages() {
        return dialog.failureMessages;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4038().getFailureMessages());
    }
}

import javax.swing.*;
import java.awt.event.*;

public class MyJVMTest_2425 {

    static JRootPane rootPane = null;

    void run() {
        if (!rootPane.isValid()) {
            throw new RuntimeException("revalidate() failed to validate the hierarchy");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2425().run();
    }
}

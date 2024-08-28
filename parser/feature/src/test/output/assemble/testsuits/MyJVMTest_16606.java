import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.awt.print.*;
import javax.swing.*;

public class MyJVMTest_16606 {

    String getAppletInfo() {
        return "Applet inf";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16606().getAppletInfo());
    }
}

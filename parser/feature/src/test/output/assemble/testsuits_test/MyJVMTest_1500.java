import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MyJVMTest_1500 {

    static Component comp = new Container();

    Window getWindowParent(Component comp) {
        while (comp != null && !(comp instanceof Window)) {
            comp = comp.getParent();
        }
        return (Window) comp;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1500().getWindowParent(comp));
    }
}

import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_6979 {

    static int NONE = 0;

    static int SHIFT = 1;

    static int CTRL = 2;

    static int ALT = 3;

    static CheckingModifierAdapter adapterTest1 = null;

    static CheckingModifierAdapter adapterTest2 = null;

    static CheckingModifierAdapter adapterTest3 = null;

    static CheckingModifierAdapter adapterTest4 = null;

    static Frame f = null;

    void initAdapters() {
        adapterTest1 = new CheckingModifierAdapter(NONE);
        adapterTest2 = new CheckingModifierAdapter(SHIFT);
        adapterTest3 = new CheckingModifierAdapter(CTRL);
        adapterTest4 = new CheckingModifierAdapter(ALT);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6979().initAdapters();
    }
}

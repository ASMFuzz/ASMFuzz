import java.awt.FocusTraversalPolicy;
import java.awt.Window;
import java.awt.Frame;

public class MyJVMTest_18184 {

    static GraphicsConfiguration winParam1Param1Param1Param1Param1 = null;

    static Frame winParam1Param1Param1Param1 = new Frame(winParam1Param1Param1Param1Param1);

    static Window winParam1Param1Param1 = new Window(winParam1Param1Param1Param1);

    static GraphicsConfiguration winParam1Param1Param2 = null;

    static Window winParam1Param1 = new Window(winParam1Param1Param1, winParam1Param1Param2);

    static Window winParam1 = new Window(winParam1Param1);

    static Window win = new Window(winParam1);

    static Class<? extends FocusTraversalPolicy> expectedPolicy = null;

    Window test(Window win, Class<? extends FocusTraversalPolicy> expectedPolicy) {
        FocusTraversalPolicy ftp = win.getFocusTraversalPolicy();
        System.out.println("==============" + "\n" + "Tested window:    " + win + "\n" + "Expected policy:  " + expectedPolicy + "\n" + "Effective policy: " + ftp.getClass());
        if (!expectedPolicy.equals(ftp.getClass())) {
            throw new RuntimeException("Test failed: wrong effective focus policy");
        }
        return win;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18184().test(win, expectedPolicy);
    }
}

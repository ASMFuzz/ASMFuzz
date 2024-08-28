import java.awt.*;

public class MyJVMTest_17225 {

    static Component comp = new Container();

    Point blockTillDisplayed(Component comp) {
        Point p = null;
        while (p == null) {
            try {
                p = comp.getLocationOnScreen();
            } catch (IllegalStateException e) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ie) {
                }
            }
        }
        return p;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17225().blockTillDisplayed(comp);
    }
}

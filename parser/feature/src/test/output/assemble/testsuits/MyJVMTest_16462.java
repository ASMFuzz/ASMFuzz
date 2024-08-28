import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_16462 {

    static Component co = new Container();

    static Panel p = new Panel(new GridLayout(1, 3));

    static int MAX_COUNT = 100;

    Point getLocation(Component co) throws RuntimeException {
        Point pt = null;
        boolean bFound = false;
        int count = 0;
        while (!bFound) {
            try {
                pt = co.getLocationOnScreen();
                bFound = true;
            } catch (Exception ex) {
                bFound = false;
                count++;
            }
            if (!bFound && count > MAX_COUNT) {
                throw new RuntimeException("don't see a component to get location");
            }
        }
        return pt;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16462().getLocation(co));
    }
}

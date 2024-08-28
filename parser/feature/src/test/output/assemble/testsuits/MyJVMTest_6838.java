import java.awt.FlowLayout;
import java.awt.Graphics;

public class MyJVMTest_6838 {

    static boolean drawLine = false;

    static boolean drawSelected = false;

    static boolean drawUnselected = false;

    boolean getResult() {
        return drawLine && drawSelected && drawUnselected;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6838().getResult());
    }
}

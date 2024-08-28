import java.awt.*;

public class MyJVMTest_13796 {

    static Component component = new Container();

    static Frame frame = null;

    Component checkFocusOwner(Component component) {
        if (component != frame.getFocusOwner()) {
            throw new RuntimeException("Test Failed! Incorrect focus owner: " + frame.getFocusOwner() + ", but expected: " + component);
        }
        return component;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13796().checkFocusOwner(component);
    }
}

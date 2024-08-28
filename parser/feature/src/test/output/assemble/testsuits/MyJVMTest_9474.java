import java.awt.*;

public class MyJVMTest_9474 {

    static String str = "0(ge;XfSmB";

    static Frame frame = new Frame();

    static Panel panel = new Panel() {

        @Override
        public boolean isValidateRoot() {
            return true;
        }
    };

    static Button button = new Button("Test");

    String printState(String str) {
        System.out.println(str + " isValid state: ");
        System.out.println("         frame: " + frame.isValid());
        System.out.println("         panel: " + panel.isValid());
        System.out.println("        button: " + button.isValid());
        return str;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9474().printState(str);
    }
}

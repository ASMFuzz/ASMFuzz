import java.awt.event.ActionListener;
import java.util.Arrays;

public class MyJVMTest_6153 {

    static String name = "#pAvo;zjYM";

    static int number = 266196483;

    static ActionListener listener = null;

    ActionListener[] getActionListeners() {
        return (this.listener != null) ? new ActionListener[] { this.listener } : new ActionListener[] {};
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_6153().getActionListeners()));
    }
}

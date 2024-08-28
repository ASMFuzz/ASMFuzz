import java.awt.event.ActionListener;
import java.util.Arrays;

public class MyJVMTest_15623 {

    static String name = ";/}cn)}moS";

    static int number = 0;

    static ActionListener listener = null;

    ActionListener[] getActionListeners() {
        return (this.listener != null) ? new ActionListener[] { this.listener } : new ActionListener[] {};
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_15623().getActionListeners()));
    }
}

import javax.swing.*;

public class MyJVMTest_11389 {

    void run() {
        new JLabel();
        UIDefaults uid = UIManager.getDefaults();
        uid.putDefaults(new Object[0]);
        uid.put("what.ever", "else");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11389().run();
    }
}

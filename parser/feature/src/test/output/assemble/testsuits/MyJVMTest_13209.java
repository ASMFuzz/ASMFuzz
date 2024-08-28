import javax.swing.*;

public class MyJVMTest_13209 {

    void init() {
        UIDefaults d = UIManager.getDefaults();
        d.toString();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13209().init();
    }
}

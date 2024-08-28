import java.awt.Frame;

public class MyJVMTest_4936 {

    void runTest() throws Exception {
        System.setSecurityManager(new SecurityManager());
        Frame f = new Frame("Test frame");
        f.setVisible(true);
        f.setVisible(false);
        f.dispose();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4936().runTest();
    }
}

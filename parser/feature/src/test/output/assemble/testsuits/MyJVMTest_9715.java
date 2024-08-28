import java.awt.BorderLayout;

public class MyJVMTest_9715 {

    static boolean useSwing = System.getProperty("useswing") != null;

    static boolean useShape = System.getProperty("useshape") != null;

    static boolean useTransl = System.getProperty("usetransl") != null;

    static boolean useNonOpaque = System.getProperty("usenonop") != null;

    void run() {
        TSFrame.createGui(useSwing, useShape, useTransl, useNonOpaque, 0.7f);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9715().run();
    }
}

import java.applet.Applet;

public class MyJVMTest_18132 {

    static String[] names = { "myformat" };

    void reset() {
        throw new IllegalStateException();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18132().reset();
    }
}

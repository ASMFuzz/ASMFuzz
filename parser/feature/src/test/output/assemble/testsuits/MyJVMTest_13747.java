import java.applet.Applet;

public class MyJVMTest_13747 {

    void reset() {
        throw new IllegalStateException();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13747().reset();
    }
}

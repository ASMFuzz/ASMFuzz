import java.applet.Applet;

public class MyJVMTest_4372 {

    void reset() {
        throw new IllegalStateException();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4372().reset();
    }
}

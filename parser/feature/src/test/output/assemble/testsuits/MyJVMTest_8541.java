import java.applet.Applet;

public class MyJVMTest_8541 {

    static String[] names = { "myformat" };

    void reset() {
        throw new IllegalStateException();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8541().reset();
    }
}

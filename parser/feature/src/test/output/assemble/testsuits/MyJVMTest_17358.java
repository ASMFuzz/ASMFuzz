import java.awt.Desktop;

public class MyJVMTest_17358 {

    static boolean isSupported = true;

    boolean checkSupported(final boolean isSupported) {
        if (isSupported != Desktop.isDesktopSupported()) {
            throw new RuntimeException();
        }
        return isSupported;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17358().checkSupported(isSupported);
    }
}

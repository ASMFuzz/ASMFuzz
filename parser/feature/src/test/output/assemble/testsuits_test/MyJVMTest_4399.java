import javax.swing.UIManager;

public class MyJVMTest_4399 {

    boolean isWindows() {
        return UIManager.getLookAndFeel().getClass().getSimpleName().equals("WindowsLookAndFeel");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4399().isWindows());
    }
}

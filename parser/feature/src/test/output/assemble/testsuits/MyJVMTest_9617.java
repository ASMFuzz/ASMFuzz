import javax.swing.UIManager;

public class MyJVMTest_9617 {

    boolean isWindowsClassic() {
        return UIManager.getLookAndFeel().getClass().getSimpleName().equals("WindowsClassicLookAndFeel");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9617().isWindowsClassic());
    }
}

import java.util.ResourceBundle;

public class MyJVMTest_17405 {

    static ResourceBundle res = null;

    static boolean passed = false;

    boolean run() {
        String str = res.getString("Hello");
        passed = str.equals("Hello from the root bundle!");
        System.out.println("Root bundle string: " + str);
        return passed;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17405().run());
    }
}

import java.util.ResourceBundle;
import java.util.Locale;

public class MyJVMTest_7267 {

    void test() {
        ResourceBundle myResources = ResourceBundle.getBundle("RB4353454", new Locale(""));
        if (!"Got it!".equals(myResources.getString("text"))) {
            throw new RuntimeException("returned wrong resource for key 'text': " + myResources.getString("text"));
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7267().test();
    }
}

import java.util.*;

public class MyJVMTest_2401 {

    void test() throws Exception {
        try {
            final ResourceBundle bundle = ResourceBundle.getBundle("bug4195978Test");
            final ResourceBundle bundle2 = ResourceBundle.getBundle("Bug4195978Test");
            String b1 = bundle.getString("test");
            String b2 = bundle2.getString("test");
            if (b1.equals("test") && b2.equals("TEST")) {
                System.out.println("Passed");
            }
        } catch (Exception e) {
            System.err.println("Failed");
            System.err.println(e);
            throw e;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2401().test();
    }
}

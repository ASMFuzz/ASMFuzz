import java.util.ListResourceBundle;
import java.util.Arrays;

public class MyJVMTest_11875 {

    Object[][] getContents() {
        return new Object[][] { { "key", "fr: message" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_11875().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_11875().getContents()[1]));
    }
}

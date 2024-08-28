import java.util.ListResourceBundle;
import java.util.Arrays;

public class MyJVMTest_2577 {

    Object[][] getContents() {
        return new Object[][] { { "key", "en: message" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_2577().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_2577().getContents()[1]));
    }
}

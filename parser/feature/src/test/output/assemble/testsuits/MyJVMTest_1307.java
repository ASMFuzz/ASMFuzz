import java.util.ListResourceBundle;
import java.util.Arrays;

public class MyJVMTest_1307 {

    Object[][] getContents() {
        return new Object[][] { { "key", "root: message" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_1307().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_1307().getContents()[1]));
    }
}

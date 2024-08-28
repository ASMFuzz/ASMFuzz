import java.util.ListResourceBundle;
import java.util.Arrays;

public class MyJVMTest_13327 {

    Object[][] getContents() {
        return new Object[][] { { "key", "yi: message" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_13327().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_13327().getContents()[1]));
    }
}

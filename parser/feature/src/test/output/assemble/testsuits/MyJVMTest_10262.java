import java.util.ListResourceBundle;
import java.util.Arrays;

public class MyJVMTest_10262 {

    Object[][] getContents() {
        return new Object[][] { { "key", "de: message" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_10262().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_10262().getContents()[1]));
    }
}

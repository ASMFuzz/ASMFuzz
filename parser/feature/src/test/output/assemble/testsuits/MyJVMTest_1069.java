import java.util.ListResourceBundle;
import java.util.Arrays;

public class MyJVMTest_1069 {

    Object[][] getContents() {
        return new Object[][] { { "key", "de: message" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_1069().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_1069().getContents()[1]));
    }
}

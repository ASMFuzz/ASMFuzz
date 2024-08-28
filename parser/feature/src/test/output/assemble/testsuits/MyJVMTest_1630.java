import java.util.ListResourceBundle;
import java.util.Arrays;

public class MyJVMTest_1630 {

    Object[][] getContents() {
        return new Object[][] { { "foo", "bar" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_1630().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_1630().getContents()[1]));
    }
}

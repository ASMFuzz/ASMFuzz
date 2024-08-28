import java.util.ListResourceBundle;
import java.util.Arrays;

public class MyJVMTest_10852 {

    Object[][] getContents() {
        return new Object[][] { { "foo", "bar" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_10852().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_10852().getContents()[1]));
    }
}

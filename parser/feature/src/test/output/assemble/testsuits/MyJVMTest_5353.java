import java.util.ListResourceBundle;
import java.util.Arrays;

public class MyJVMTest_5353 {

    Object[][] getContents() {
        return new Object[][] { { "dummy", "toto" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_5353().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_5353().getContents()[1]));
    }
}

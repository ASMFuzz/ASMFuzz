import java.util.ListResourceBundle;
import java.util.Arrays;

public class MyJVMTest_17167 {

    Object[][] getContents() {
        return new Object[][] { { "OkKey", "OK" }, { "CancelKey", "Cancel" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_17167().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_17167().getContents()[1]));
    }
}

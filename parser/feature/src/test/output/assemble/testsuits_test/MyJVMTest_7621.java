import java.util.ListResourceBundle;
import java.util.Arrays;

public class MyJVMTest_7621 {

    Object[][] getContents() {
        return new Object[][] { { "OkKey", "OK" }, { "CancelKey", "Cancel" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_7621().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_7621().getContents()[1]));
    }
}

import java.util.ListResourceBundle;
import java.util.Arrays;

public class MyJVMTest_16896 {

    Object[][] getContents() {
        return new Object[][] { { "msg", "test" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_16896().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_16896().getContents()[1]));
    }
}

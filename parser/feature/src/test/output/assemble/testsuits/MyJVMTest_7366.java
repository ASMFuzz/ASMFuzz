import java.util.ListResourceBundle;
import java.util.Arrays;

public class MyJVMTest_7366 {

    Object[][] getContents() {
        return new Object[][] { { "msg", "test" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_7366().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_7366().getContents()[1]));
    }
}

import java.util.ListResourceBundle;
import java.util.Arrays;

public class MyJVMTest_1931 {

    Object[][] getContents() {
        return new Object[][] { { "name", "Bug4168625Resource" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_1931().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_1931().getContents()[1]));
    }
}

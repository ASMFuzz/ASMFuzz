import java.util.ListResourceBundle;
import java.util.Arrays;

public class MyJVMTest_3740 {

    Object[][] getContents() {
        return new Object[][] { { "name", "Bug4168625Resource3_en" }, { "Bug4168625Resource3_en", "Bug4168625Resource3_en" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_3740().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_3740().getContents()[1]));
    }
}

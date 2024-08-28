import java.util.ListResourceBundle;
import java.util.Arrays;

public class MyJVMTest_2934 {

    Object[][] getContents() {
        return new Object[][] { { "name", "Bug4168625Resource2_en_US" }, { "Bug4168625Resource2_en_US", "Bug4168625Resource2_en_US" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_2934().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_2934().getContents()[1]));
    }
}

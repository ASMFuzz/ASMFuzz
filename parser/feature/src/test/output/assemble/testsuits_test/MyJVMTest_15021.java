import java.util.ListResourceBundle;
import java.util.Arrays;

public class MyJVMTest_15021 {

    Object[][] getContents() {
        return new Object[][] { { "name", "Bug4168625Resource2" }, { "baseName", "Bug4168625Resource2" }, { "Bug4168625Resource2", "Bug4168625Resource2" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_15021().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_15021().getContents()[1]));
    }
}

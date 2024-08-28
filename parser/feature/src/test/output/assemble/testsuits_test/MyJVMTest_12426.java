import java.util.ListResourceBundle;
import java.util.Arrays;

public class MyJVMTest_12426 {

    Object[][] getContents() {
        return new Object[][] { { "name", "Bug4168625Resource3" }, { "Bug4168625Resource3", "Bug4168625Resource3" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_12426().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_12426().getContents()[1]));
    }
}

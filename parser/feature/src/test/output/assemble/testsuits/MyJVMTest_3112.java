import java.util.ListResourceBundle;
import java.util.Arrays;

public class MyJVMTest_3112 {

    Object[][] getContents() {
        return new Object[][] { { "name", "Bug4168625Resource3" }, { "Bug4168625Resource3", "Bug4168625Resource3" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_3112().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_3112().getContents()[1]));
    }
}

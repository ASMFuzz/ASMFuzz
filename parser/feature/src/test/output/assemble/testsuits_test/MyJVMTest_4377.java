import java.util.ListResourceBundle;
import java.util.Arrays;

public class MyJVMTest_4377 {

    Object[][] getContents() {
        return new Object[][] { { "name", "Bug4168625Resource3_en_IE" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_4377().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_4377().getContents()[1]));
    }
}

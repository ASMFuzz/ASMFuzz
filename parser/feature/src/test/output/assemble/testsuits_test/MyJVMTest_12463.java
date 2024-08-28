import java.util.ListResourceBundle;
import java.util.Arrays;

public class MyJVMTest_12463 {

    Object[][] getContents() {
        return new Object[][] { { "name", "Bug4168625Resource3_en_CA" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_12463().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_12463().getContents()[1]));
    }
}

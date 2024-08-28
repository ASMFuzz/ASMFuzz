import java.util.ListResourceBundle;
import java.util.Arrays;

public class MyJVMTest_16116 {

    Object[][] getContents() {
        return new Object[][] { {} };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_16116().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_16116().getContents()[1]));
    }
}

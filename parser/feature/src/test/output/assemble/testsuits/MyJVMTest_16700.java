import java.util.ListResourceBundle;
import java.util.Arrays;

public class MyJVMTest_16700 {

    Object[][] getContents() {
        return new Object[][] { { "key", "es: message" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_16700().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_16700().getContents()[1]));
    }
}

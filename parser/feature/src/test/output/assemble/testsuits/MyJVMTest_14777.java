import java.util.ListResourceBundle;
import java.util.Arrays;

public class MyJVMTest_14777 {

    Object[][] getContents() {
        return new Object[][] { { "dummy", "toto" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_14777().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_14777().getContents()[1]));
    }
}

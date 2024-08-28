import java.util.ListResourceBundle;
import java.util.Arrays;

public class MyJVMTest_12993 {

    Object[][] getContents() {
        return new Object[][] { { "name2", "Test4314141B_fr_CH.class" }, { "name3", "Test4314141B_fr_CH.class" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_12993().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_12993().getContents()[1]));
    }
}

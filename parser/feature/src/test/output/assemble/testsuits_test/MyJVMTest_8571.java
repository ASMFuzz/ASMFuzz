import java.util.ListResourceBundle;
import java.util.Arrays;

public class MyJVMTest_8571 {

    Object[][] getContents() {
        return new Object[][] { { "name0", "Test4314141B.class" }, { "name1", "Test4314141B.class" }, { "name2", "Test4314141B.class" }, { "name3", "Test4314141B.class" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_8571().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_8571().getContents()[1]));
    }
}

import java.util.ListResourceBundle;
import java.util.Arrays;

public class MyJVMTest_8308 {

    Object[][] getContents() {
        return new Object[][] { { "name2", "Test4314141B_es_ES.class" }, { "name3", "Test4314141B_es_ES.class" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_8308().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_8308().getContents()[1]));
    }
}

import java.util.*;

public class MyJVMTest_16384 {

    Object[][] getContents() {
        return new Object[][] { { "type", "class (static initializer error)" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_16384().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_16384().getContents()[1]));
    }
}

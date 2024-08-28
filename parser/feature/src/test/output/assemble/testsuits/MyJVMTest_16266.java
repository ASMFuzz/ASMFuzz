import java.util.*;

public class MyJVMTest_16266 {

    Object[][] getContents() {
        return new Object[][] { { "type", "class (no no-arg constructor)" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_16266().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_16266().getContents()[1]));
    }
}

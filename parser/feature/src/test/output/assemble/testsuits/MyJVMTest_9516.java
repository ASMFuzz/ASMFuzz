import java.util.*;

public class MyJVMTest_9516 {

    Object[][] getContents() {
        return new Object[][] { { "type", "class (private constructor)" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_9516().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_9516().getContents()[1]));
    }
}

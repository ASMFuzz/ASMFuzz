import java.util.*;

public class MyJVMTest_9682 {

    Object[][] getContents() {
        return new Object[][] { { "type", "java.class" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_9682().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_9682().getContents()[1]));
    }
}

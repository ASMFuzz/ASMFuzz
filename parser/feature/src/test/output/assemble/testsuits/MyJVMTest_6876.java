import java.util.*;

public class MyJVMTest_6876 {

    Object[][] getContents() {
        return new Object[][] { { "type", "class (static initializer error)" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_6876().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_6876().getContents()[1]));
    }
}

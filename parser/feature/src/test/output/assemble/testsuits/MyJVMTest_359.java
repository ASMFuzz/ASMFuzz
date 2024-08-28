import java.util.*;

public class MyJVMTest_359 {

    Object[][] getContents() {
        return new Object[][] { { "type", "class (private constructor)" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_359().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_359().getContents()[1]));
    }
}

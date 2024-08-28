import java.util.*;

public class MyJVMTest_5177 {

    Object[][] getContents() {
        return new Object[][] { { "type", "class (package1.PackagePrivateRB)" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_5177().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_5177().getContents()[1]));
    }
}

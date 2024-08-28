import java.security.*;
import java.util.*;

public class MyJVMTest_3696 {

    static PropertyPermission filePerm = new PropertyPermission("file.separator", "read");

    Object run() {
        AccessController.getContext().checkPermission(filePerm);
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3696().run());
    }
}

import java.security.*;
import java.util.*;

public class MyJVMTest_15043 {

    static PropertyPermission pathPerm = new PropertyPermission("path.separator", "read");

    Object run() {
        AccessController.getContext().checkPermission(pathPerm);
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15043().run());
    }
}

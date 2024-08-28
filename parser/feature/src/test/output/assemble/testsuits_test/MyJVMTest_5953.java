import java.lang.reflect.*;

public class MyJVMTest_5953 {

    void stackWalk() {
        try {
            Class b = Object.class;
            SecurityManager sm = new SecurityManager();
            sm.checkPermission(new RuntimePermission("accessDeclaredMembers"));
        } catch (java.security.AccessControlException e) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5953().stackWalk();
    }
}

import java.lang.annotation.*;

public class MyJVMTest_14298 {

    static Object o = 449694898;

    Class getLocalClass(Object o) {
        class Local {
        }
        ;
        Local l = new Local();
        return l.getClass();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14298().getLocalClass(o));
    }
}

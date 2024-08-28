import java.lang.annotation.*;

public class MyJVMTest_4898 {

    static Object o = 82750121;

    Class getLocalClass(Object o) {
        class Local {
        }
        ;
        Local l = new Local();
        return l.getClass();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4898().getLocalClass(o));
    }
}

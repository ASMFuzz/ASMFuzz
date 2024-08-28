import java.lang.reflect.*;

public class MyJVMTest_5911 {

    static T a = null;

    <T> T g(T a) {
        return;
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5911().g(a);
    }
}

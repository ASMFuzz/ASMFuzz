import java.lang.reflect.*;

public class MyJVMTest_15362 {

    static T a = null;

    <T> T g(T a) {
        return;
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15362().g(a);
    }
}

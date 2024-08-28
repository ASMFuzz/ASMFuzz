import static java.lang.invoke.MethodHandles.*;

public class MyJVMTest_9316 {

    String method() {
        return "privateMethod";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9316().method());
    }
}

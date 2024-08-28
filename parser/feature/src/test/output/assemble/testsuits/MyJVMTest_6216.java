import java.lang.invoke.*;

public class MyJVMTest_6216 {

    String publicMethod() {
        return "publicMethod";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6216().publicMethod());
    }
}

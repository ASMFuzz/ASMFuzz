import java.lang.invoke.*;

public class MyJVMTest_8186 {

    String privateMethod() {
        return "privateMethod";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8186().privateMethod());
    }
}

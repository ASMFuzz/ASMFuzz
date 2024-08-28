import java.lang.invoke.*;

public class MyJVMTest_15689 {

    String publicMethod() {
        return "publicMethod";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15689().publicMethod());
    }
}

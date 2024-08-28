import java.lang.invoke.*;

public class MyJVMTest_11350 {

    String protectedMethod() {
        return "protectedMethod";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11350().protectedMethod());
    }
}

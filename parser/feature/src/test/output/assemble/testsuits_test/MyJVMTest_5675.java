import java.util.regex.*;

public class MyJVMTest_5675 {

    void call() {
        boolean match = false;
        String classNameRegex = "[a-zA-Z_][[\\w]|\\$]*";
        match = Pattern.matches(classNameRegex, "SimpleApp2");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5675().call();
    }
}

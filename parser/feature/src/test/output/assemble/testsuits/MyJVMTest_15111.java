import java.util.regex.*;

public class MyJVMTest_15111 {

    void call() {
        boolean match = false;
        String classNameRegex = "[a-zA-Z_][[\\w]|\\$]*";
        match = Pattern.matches(classNameRegex, "SimpleApp2");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15111().call();
    }
}

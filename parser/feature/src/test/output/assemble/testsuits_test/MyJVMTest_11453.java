import java.lang.invoke.*;

public class MyJVMTest_11453 {

    String packageMethod() {
        return "packageMethod";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11453().packageMethod());
    }
}

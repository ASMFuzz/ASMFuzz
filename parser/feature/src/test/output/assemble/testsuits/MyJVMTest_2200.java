import java.lang.invoke.*;

public class MyJVMTest_2200 {

    String packageMethod() {
        return "packageMethod";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2200().packageMethod());
    }
}

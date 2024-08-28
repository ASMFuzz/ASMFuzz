import java.lang.invoke.*;

public class MyJVMTest_3103 {

    String iString() {
        return "b";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3103().iString());
    }
}

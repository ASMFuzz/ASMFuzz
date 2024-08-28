import java.nio.file.Path;

public class MyJVMTest_5402 {

    String getName() {
        return "Test";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5402().getName());
    }
}

import java.nio.channels.*;

public class MyJVMTest_7793 {

    boolean isOpen() {
        throw new RuntimeException("not implemented");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7793().isOpen());
    }
}

import java.nio.channels.*;

public class MyJVMTest_17350 {

    boolean isOpen() {
        throw new RuntimeException("not implemented");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17350().isOpen());
    }
}

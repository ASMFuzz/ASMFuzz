import java.awt.FlowLayout;
import java.awt.Graphics;

public class MyJVMTest_13496 {

    static boolean isIntMethodCalled = false;

    static boolean isFPMethodCalled = false;

    boolean getResult() {
        return !isIntMethodCalled && isFPMethodCalled;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13496().getResult());
    }
}

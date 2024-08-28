import java.util.Arrays;

public class MyJVMTest_3961 {

    static TestListener listener = null;

    TestListener[] getTestListeners() {
        return (this.listener != null) ? new TestListener[] { this.listener } : new TestListener[0];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_3961().getTestListeners()));
    }
}

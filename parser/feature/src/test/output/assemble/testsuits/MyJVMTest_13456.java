import java.lang.reflect.*;

public class MyJVMTest_13456 {

    void work() throws Exception {
        throw new Exception("Sample exception");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13456().work();
    }
}

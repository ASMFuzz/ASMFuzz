import java.lang.reflect.*;

public class MyJVMTest_4097 {

    void work() throws Exception {
        throw new Exception("Sample exception");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4097().work();
    }
}

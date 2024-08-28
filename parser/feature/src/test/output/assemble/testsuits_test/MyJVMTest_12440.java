import java.io.*;
import java.util.*;

public class MyJVMTest_12440 {

    void e() throws LowLevelException {
        throw new LowLevelException();
    }

    void d() throws LowLevelException {
        e();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12440().d();
    }
}

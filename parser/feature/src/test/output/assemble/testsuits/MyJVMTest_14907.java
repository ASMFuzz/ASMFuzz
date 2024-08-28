import java.io.*;
import java.util.*;

public class MyJVMTest_14907 {

    void e() throws LowLevelException {
        throw new LowLevelException();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14907().e();
    }
}

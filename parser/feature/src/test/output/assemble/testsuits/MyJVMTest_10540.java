import java.io.*;
import java.util.*;

public class MyJVMTest_10540 {

    void selfReference() {
        Throwable throwable1 = new RuntimeException();
        Throwable throwable2 = new AssertionError();
        throwable1.initCause(throwable2);
        throwable2.initCause(throwable1);
        throwable1.printStackTrace();
        throwable1.addSuppressed(throwable2);
        throwable2.addSuppressed(throwable1);
        throwable1.printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10540().selfReference();
    }
}

import java.io.*;
import java.util.*;

public class MyJVMTest_6712 {

    void noSelfSuppression() {
        Throwable throwable = new Throwable();
        try {
            throwable.addSuppressed(throwable);
            throw new RuntimeException("IllegalArgumentException for self-suppresion not thrown.");
        } catch (IllegalArgumentException iae) {
            if (iae.getCause() != throwable)
                throw new RuntimeException("Bad cause after self-suppresion.");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6712().noSelfSuppression();
    }
}

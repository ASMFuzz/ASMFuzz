import java.lang.management.*;
import javax.management.*;
import java.util.*;
import static java.lang.management.ManagementFactory.*;

public class MyJVMTest_8020 {

    static JMRuntimeException e = new JMRuntimeException();

    Throwable checkMBeanException(JMRuntimeException e) {
        Throwable cause = e.getCause();
        if (!(cause instanceof UnsupportedOperationException)) {
            throw new RuntimeException("TEST FAILED: " + cause + "is not UnsupportedOperationException");
        }
        return cause;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8020().checkMBeanException(e);
    }
}

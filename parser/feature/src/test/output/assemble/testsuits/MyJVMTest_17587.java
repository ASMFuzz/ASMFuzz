import java.lang.management.*;
import javax.management.*;
import java.util.*;
import static java.lang.management.ManagementFactory.*;

public class MyJVMTest_17587 {

    static String eParam1 = "Om<\"Y?SXvq";

    static JMRuntimeException e = new JMRuntimeException(eParam1);

    Throwable checkMBeanException(JMRuntimeException e) {
        Throwable cause = e.getCause();
        if (!(cause instanceof UnsupportedOperationException)) {
            throw new RuntimeException("TEST FAILED: " + cause + "is not UnsupportedOperationException");
        }
        return cause;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17587().checkMBeanException(e);
    }
}
